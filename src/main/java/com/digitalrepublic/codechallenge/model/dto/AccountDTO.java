package com.digitalrepublic.codechallenge.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.digitalrepublic.codechallenge.model.entities.Account;
import com.digitalrepublic.codechallenge.model.entities.Client;

public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private BigDecimal balance;
    private BigDecimal deposit;

    public AccountDTO() {}

    public AccountDTO(Long id, BigDecimal balance, Integer accountNumber, BigDecimal deposit) {
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
}