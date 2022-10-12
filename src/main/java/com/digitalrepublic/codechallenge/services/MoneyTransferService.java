package com.digitalrepublic.codechallenge.services;

import com.digitalrepublic.codechallenge.model.dto.MoneyTransferDTO;
import com.digitalrepublic.codechallenge.model.entities.Account;
import com.digitalrepublic.codechallenge.model.entities.MoneyTransfer;
import com.digitalrepublic.codechallenge.model.repositories.AccountRepository;
import com.digitalrepublic.codechallenge.model.repositories.MoneyTransferRepository;
import com.digitalrepublic.codechallenge.services.exceptions.BalanceCantCompleteException;
import com.digitalrepublic.codechallenge.services.exceptions.CantCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class MoneyTransferService {
    
    @Autowired
    private MoneyTransferRepository moneyTransferRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public MoneyTransferDTO transferMoney(MoneyTransferDTO dto) {
        Account account1 = accountRepository.findById(dto.getFromAccountNumber()).get();
        BigDecimal currentBalance1 = account1.getBalance().subtract(dto.getAmount());
        account1.setBalance(currentBalance1);
        accountRepository.save(account1);
        Account account2 = accountRepository.findById(dto.getToAccountNumber()).get();
        BigDecimal currentBalance2 = account2.getBalance().add(dto.getAmount());
        account2.setBalance(currentBalance2);
        accountRepository.save(account2);

        MoneyTransfer entity = new MoneyTransfer();

        entity.setFromAccountNumber(dto.getFromAccountNumber());
        entity.setToAccountNumber(dto.getToAccountNumber());
        entity.setAmount(dto.getAmount());
        entity.setTransferDate(Instant.now());
        moneyTransferRepository.save(entity);
        if (currentBalance1.doubleValue() < 0.00) {
            throw new BalanceCantCompleteException("You can't have negative balance");
        }
        if(entity.getAmount().doubleValue() > 2000.00) {
            throw new CantCompleteException("You can't transfer more than $ 2000.00");
        }
        return new MoneyTransferDTO(entity);
    }
}