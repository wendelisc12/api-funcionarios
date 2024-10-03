package com.atividade.atividadeAcc.repository;

import com.atividade.atividadeAcc.entities.Departament;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Departament, Integer> {
}
