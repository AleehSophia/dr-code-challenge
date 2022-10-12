package com.digitalrepublic.codechallenge.model.entities;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.*;

@Entity
@Table(name = "tb_transfer")
public class MoneyTransfer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer accountNumber;
    private Integer fromAccountNumber;
    private Integer toAccountNumber;
    private BigDecimal amount;
    
    @Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant transferDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    
    public MoneyTransfer() {}

    public MoneyTransfer(Long id, Integer accountNumber, Integer fromAccountNumber, Integer toAccountNumber, BigDecimal amount, Instant transferDate, Account account) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.transferDate = transferDate;
        this.account = account;
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

    public void setTransferDate(Instant transferDate) {
        this.transferDate = transferDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MoneyTransfer other = (MoneyTransfer) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }      
}