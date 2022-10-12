package com.digitalrepublic.codechallenge.model.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tb_account")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer accountNumber;
    private BigDecimal deposit;
    private BigDecimal balance;
    
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    @OneToMany(mappedBy = "account")
    private List<MoneyTransfer> moneyTransfers;

    public Account() {}

    public Account(Long id, BigDecimal balance, Integer accountNumber, BigDecimal deposit, Client client) {
        this.id = id;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.client = client;
        this.deposit = deposit;
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

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public List<MoneyTransfer> getMoneyTransfers() {
        return moneyTransfers;
    }

    public void setMoneyTransfers(List<MoneyTransfer> moneyTransfers) {
        this.moneyTransfers = moneyTransfers;
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
        Account other = (Account) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}