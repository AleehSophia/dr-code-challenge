package com.digitalrepublic.codechallenge.services;

import com.digitalrepublic.codechallenge.model.dto.AccountDTO;
import com.digitalrepublic.codechallenge.model.entities.Account;
import com.digitalrepublic.codechallenge.model.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigDecimal;

@Service
public class AccountService implements Serializable {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public AccountDTO deposit(AccountDTO dto) {
        Account entity = new Account();
        entity.setDeposit(dto.getDeposit());
        entity.setBalance(dto.getDeposit());
        entity.setClient(dto.getClient());
        accountRepository.save(entity);

        return new AccountDTO(entity);
    }

    @Transactional
    public AccountDTO transferMoney(long accountId, long destinyAccountId, BigDecimal amount) {
        Account entity = new Account();
        accountRepository.withDraw(accountId, amount);
        accountRepository.saveBalance(destinyAccountId, amount);
        accountRepository.save(entity);
        return new AccountDTO(entity);
    }
}