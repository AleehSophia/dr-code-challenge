package com.digitalrepublic.codechallenge.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalrepublic.codechallenge.model.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> { 
}