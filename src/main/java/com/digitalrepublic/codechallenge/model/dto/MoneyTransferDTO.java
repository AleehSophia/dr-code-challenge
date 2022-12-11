package com.digitalrepublic.codechallenge.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import com.digitalrepublic.codechallenge.model.entities.Account;
import com.digitalrepublic.codechallenge.model.entities.MoneyTransfer;

public class MoneyTransferDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long fromAccountNumber;
    private Long toAccountNumber;
    private Double amount;
    private Instant transferDate;
    
    public MoneyTransferDTO() {}

    public MoneyTransferDTO(Long id, Long fromAccountNumber, Long toAccountNumber, Double amount, Instant transferDate) {
        this.id = id;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.transferDate = transferDate;
    }

    public MoneyTransferDTO(MoneyTransfer entity) {
        this.id = entity.getId();
        this.fromAccountNumber = entity.getFromAccountNumber();
        this.toAccountNumber = entity.getToAccountNumber();
        this.amount = entity.getAmount();
        this.transferDate = entity.getTransferDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(Long fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public Long getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(Long toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Instant getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Instant transferDate) {
        this.transferDate = transferDate;
    }   
}