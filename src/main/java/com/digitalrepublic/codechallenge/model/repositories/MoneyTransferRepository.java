package com.digitalrepublic.codechallenge.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalrepublic.codechallenge.model.entities.MoneyTransfer;

@Repository
public interface MoneyTransferRepository extends JpaRepository<MoneyTransfer, Long> {
    
    List<MoneyTransfer> findByAccountNumberEquals(String accountNumber);
}