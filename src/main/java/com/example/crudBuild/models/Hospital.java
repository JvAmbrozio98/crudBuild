package com.example.crudBuild.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Hospitals ")


public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "Nome")
    private String name;

    @Column(name = "Endereco")
    private String address ;

    @Column (name = "Situacao")
    private String situation;

    @Column(name = "Capacidade")
    private Integer capacity;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

