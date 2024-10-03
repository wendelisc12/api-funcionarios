package com.atividade.atividadeAcc.repository;

import com.atividade.atividadeAcc.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByNameStartingWith(String name);
    List<User> findByDepartamentId(Integer departamentId);
}
