package com.digitalrepublic.codechallenge.model.dto;

import java.io.Serializable;
import java.time.Instant;

import com.digitalrepublic.codechallenge.model.entities.MoneyTransfer;

public class MoneyTransferDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer accountNumber;

    private Double amount;
    private Instant transferDate;
    
    public MoneyTransferDTO() {}

    public MoneyTransferDTO(Long id, Integer accountNumber, Double amount, Instant transferDate) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transferDate = transferDate;
    }

    public MoneyTransferDTO(MoneyTransfer entity) {
        id = entity.getId();
        accountNumber = entity.getAccountNumber();
        amount = entity.getAmount();
        transferDate = entity.getTransferDate();
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