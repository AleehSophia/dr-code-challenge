package com.digitalrepublic.codechallenge.services;

import com.digitalrepublic.codechallenge.model.dto.AccountDTO;
import com.digitalrepublic.codechallenge.model.entities.Account;
import com.digitalrepublic.codechallenge.model.repositories.AccountRepository;
import com.digitalrepublic.codechallenge.services.exceptions.CantCompleteException;
import com.digitalrepublic.codechallenge.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Service
public class AccountService implements Serializable {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public AccountDTO deposit(AccountDTO dto) {
        Optional<Account> account = accountRepository.findById(dto.getId());
        if (account.isEmpty()) {
            throw new ResourceNotFoundException("Account not found");
        }
        if (account.get().getBalance() == null) {
            throw new CantCompleteException("You need to use first deposit transaction if you never had money in your balance");
        }
        Double currentBalance = account.get().getBalance() + dto.getDeposit();
        account.get().setBalance(currentBalance);


        account.get().setDeposit(dto.getDeposit());

        accountRepository.save(account.get());

        return new AccountDTO(account.get());
    }

    @Transactional
    public AccountDTO firstDeposit(AccountDTO dto) {
        Account account = accountRepository.findById(dto.getId()).get();
        if (account.getBalance() != null) {
            throw new CantCompleteException("You can't use first deposit if you already have money in your balance");
        }
        account.setDeposit(dto.getDeposit());
        account.setBalance(dto.getDeposit());
        accountRepository.save(account);
        return new AccountDTO(account);
    }
}