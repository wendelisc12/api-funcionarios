package com.atividade.atividadeAcc.controllers;

import com.atividade.atividadeAcc.entities.Departament;
import com.atividade.atividadeAcc.repository.DepartamentRepository;
import com.atividade.atividadeAcc.entities.User;
import com.atividade.atividadeAcc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/departaments")
public class DepartamentController {

    @Autowired
    DepartamentRepository departamentRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<Departament> departaments() {
        try {
            List<Departament> results = departamentRepository.findAll();
            return results;
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping(value = "/{id}/users")
    public List<User> getUsersByDepartamentId(@PathVariable Integer id) {
        try {
            List<User> users = userRepository.findByDepartamentId(id);
            return users;
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public Departament getDepartamentById(@PathVariable Integer id){
        try{
            Departament results =  departamentRepository.findById(id).get();
            return results;
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping
    public Departament insertDepartament(@RequestBody Departament departament) {
        try {
            Departament novoDepartament = departamentRepository.save(departament);
            return novoDepartament;
        }catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDepartament(@PathVariable Integer id) {
        try {
            departamentRepository.deleteById(id);
        }catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
