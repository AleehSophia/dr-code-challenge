package com.digitalrepublic.codechallenge.model.dto;

import java.io.Serializable;
import java.time.Instant;

import com.digitalrepublic.codechallenge.model.entities.MoneyTransfer;

public class MoneyTransferDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long accountIdFrom;
    private Long accountIdTo;
    private Double amount;
    private Instant transferDate;
    
    public MoneyTransferDTO() {}

    public MoneyTransferDTO(Long id, Long accountIdFrom, Long accountIdTo, Double amount, Instant transferDate) {
        this.id = id;
        this.accountIdFrom = accountIdFrom;
        this.accountIdTo = accountIdTo;
        this.amount = amount;
        this.transferDate = transferDate;
    }

    public MoneyTransferDTO(MoneyTransfer entity) {
        id = entity.getId();
        accountIdFrom = entity.getAccountIdFrom();
        accountIdTo = entity.getAccountIdFrom();
        amount = entity.getAmount();
        transferDate = entity.getTransferDate();
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

    public Long getAccountIdFrom() {
        return accountIdFrom;
    }

    public void setAccountIdFrom(Long accountIdFrom) {
        this.accountIdFrom = accountIdFrom;
    }

    public Long getAccountIdTo() {
        return accountIdTo;
    }

    public void setAccountIdTo(Long accountIdTo) {
        this.accountIdTo = accountIdTo;
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