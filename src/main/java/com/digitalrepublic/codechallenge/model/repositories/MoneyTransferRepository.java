package com.digitalrepublic.codechallenge.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalrepublic.codechallenge.model.entities.MoneyTransfer;

public interface MoneyTransferRepository extends JpaRepository<MoneyTransfer, Long> {   
}