package com.digitalrepublic.codechallenge.model.dto;

import java.io.Serializable;

import com.digitalrepublic.codechallenge.model.entities.Account;

public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String cpf;
    private Double balance;
    private Double deposit;

    public AccountDTO() {}

    public AccountDTO(Long id, String name, String cpf, Double balance, Double deposit) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.balance = balance;
        this.deposit = deposit;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }
}