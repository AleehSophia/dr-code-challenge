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
        Account account = accountRepository.findById(dto.getId()).get();
        BigDecimal currentBalance = account.getBalance().add(dto.getDeposit());
        account.setBalance(currentBalance);
        accountRepository.save(account);

        account.setDeposit(dto.getDeposit());

        return new AccountDTO(account);
    }

    public AccountDTO firstDeposit(AccountDTO dto) {
        Account account = accountRepository.findById(dto.getId()).get();
        account.setDeposit(dto.getDeposit());
        account.setBalance(dto.getDeposit());
        accountRepository.save(account);
        return new AccountDTO(account);
    }
}