package com.digitalrepublic.codechallenge.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.digitalrepublic.codechallenge.model.entities.Account;
import com.digitalrepublic.codechallenge.model.entities.Client;

public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private BigDecimal balance;
    private Integer accountNumber;
    private BigDecimal deposit;
    private Client client;

    public AccountDTO() {}

    public AccountDTO(Long id, BigDecimal balance, Integer accountNumber, BigDecimal deposit, Client client) {
        this.id = id;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.deposit = deposit;
        this.client = client;
    }

    public AccountDTO(Account entity) {
        this.id = entity.getId();
        this.balance = entity.getBalance();
        this.accountNumber = entity.getAccountNumber();
        this.client = entity.getClient();
        this.deposit = entity.getDeposit();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }
}