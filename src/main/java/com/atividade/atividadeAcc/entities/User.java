package com.atividade.atividadeAcc.entities;

import jakarta.persistence.*;


@Entity
@Table (name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_departament")
    private Departament departament;

    public User(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public Departament getDepartament() {
        return departament;
    }
}
