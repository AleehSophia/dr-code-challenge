package com.digitalrepublic.codechallenge.model.repositories;

import com.digitalrepublic.codechallenge.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}