package com.digitalrepublic.codechallenge.model.dto;

import java.io.Serializable;

import com.digitalrepublic.codechallenge.model.entities.Account;

public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String cpf;

    public AccountDTO() {}

    public AccountDTO(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public AccountDTO(Account entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}