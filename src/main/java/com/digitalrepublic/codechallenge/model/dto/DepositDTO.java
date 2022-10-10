package com.digitalrepublic.codechallenge.model.dto;

import com.digitalrepublic.codechallenge.model.entities.Deposit;

public class DepositDTO {
    
    private Long id;
    private Double amount;

    public DepositDTO() {}

    public DepositDTO(Long id, Double amount) {
        this.id = id;
        this.amount = amount;
    }

    public DepositDTO(Deposit entity) {
        id = entity.getId();
        amount = entity.getAmount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }   
}