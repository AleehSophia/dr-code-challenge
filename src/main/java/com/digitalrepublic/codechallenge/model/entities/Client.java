package com.digitalrepublic.codechallenge.model.entities;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    @Column(name = "cpf", unique = true)
    private String cpf;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Account account;

    public Client() {}

    public Client(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}