package com.example.crudBuild.models;

import jakarta.persistence.*;

@Entity
@Table(name = "UsersInApp")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Nome")
    private String name;

    @Column(name = "Idade")
    private String age;

    @Column(name = "Sexo")
    private String gender;

    @Column(name = "Sintoma")
    private String condition;

    @Column(name = "Endereco")
    private String address ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

