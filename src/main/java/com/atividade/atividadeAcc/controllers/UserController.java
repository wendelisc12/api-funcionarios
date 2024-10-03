package com.atividade.atividadeAcc.controllers;

import com.atividade.atividadeAcc.entities.User;
import com.atividade.atividadeAcc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> usuarios(){
        try {
            List<User> results = userRepository.findAll();
            return results;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }

    @GetMapping(value = "/{id}")
    public User usuario(@PathVariable Integer id){
        try {
            User results = userRepository.findById(id).get();
            return results;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }

    @GetMapping(value = "/name/{name}")
    public List<User> getUsuariosByName(@PathVariable String name){
        try{
            List<User> results = userRepository.findByNameStartingWith(name);
            return results;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public User insertUser(@RequestBody User user){
        try {
            User newUser = userRepository.save(user);
            return newUser;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }

    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Integer id){
        try{
            userRepository.deleteById(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Não foi possível deletar usuário" );
        }
    }

}
