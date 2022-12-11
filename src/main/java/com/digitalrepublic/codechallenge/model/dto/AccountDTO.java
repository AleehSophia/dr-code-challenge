package com.digitalrepublic.codechallenge.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.digitalrepublic.codechallenge.model.entities.Account;
import com.digitalrepublic.codechallenge.model.entities.Client;

public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Double balance;
    private Double deposit;

    public AccountDTO() {}

    public AccountDTO(Long id, Double balance, Integer accountNumber, Double deposit) {
        this.id = id;
        this.balance = balance;
        this.deposit = deposit;
    }

    public AccountDTO(Account entity) {
        this.id = entity.getId();
        this.balance = entity.getBalance();
        this.deposit = entity.getDeposit();
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

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }
}