package com.digitalrepublic.codechallenge.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalrepublic.codechallenge.model.entities.Account;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface AccountRepository extends JpaRepository<Account, Long> { 

    @Query("update Account set balance = balance+?2 where id=?1")
    public void saveBalance(long id, BigDecimal balance);

    @Query("update Account set balance = balance-?2 where id=?1")
    public void withDraw(long id, BigDecimal balance);

}