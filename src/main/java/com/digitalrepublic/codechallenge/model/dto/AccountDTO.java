package com.digitalrepublic.codechallenge.model.dto;

import java.io.Serializable;

import com.digitalrepublic.codechallenge.model.entities.Account;
import com.digitalrepublic.codechallenge.model.entities.Client;

public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Double balance;
    private Client client;

    public AccountDTO() {}

    public AccountDTO(Long id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    public AccountDTO(Account entity) {
        this.id = entity.getId();
        this.balance = entity.getBalance();
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }   
}