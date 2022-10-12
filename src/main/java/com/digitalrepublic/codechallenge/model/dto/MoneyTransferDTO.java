package com.digitalrepublic.codechallenge.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import com.digitalrepublic.codechallenge.model.entities.Account;
import com.digitalrepublic.codechallenge.model.entities.MoneyTransfer;

public class MoneyTransferDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer accountNumber;
    private Integer fromAccountNumber;
    private Integer toAccountNumber;
    private BigDecimal amount;
    private Instant transferDate;

    private Account account;
    
    public MoneyTransferDTO() {}

    public MoneyTransferDTO(Long id, Integer accountNumber, Integer fromAccountNumber, Integer toAccountNumber, BigDecimal amount, Instant transferDate, Account account) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.transferDate = transferDate;
        this.account = account;
    }

    public MoneyTransferDTO(MoneyTransfer entity) {
        this.id = entity.getId();
        this.accountNumber = entity.getAccountNumber();
        this.fromAccountNumber = entity.getFromAccountNumber();
        this.toAccountNumber = entity.getToAccountNumber();
        this.amount = entity.getAmount();
        this.transferDate = entity.getTransferDate();
        this.account = entity.getAccount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(Integer fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public Integer getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(Integer toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Instant getTransferDate() {
        return transferDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setTransferDate(Instant transferDate) {
        this.transferDate = transferDate;
    }   
}