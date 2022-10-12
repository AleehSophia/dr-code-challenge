package com.digitalrepublic.codechallenge.model.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "cpf", unique = true)
    private String cpf;

    @OneToOne(mappedBy = "client")
    private Account account;

    public Client() {}

    public Client(Long id, String name, String cpf, Account account) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}