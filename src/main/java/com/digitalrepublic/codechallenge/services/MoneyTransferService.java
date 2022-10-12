package com.digitalrepublic.codechallenge.services;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

import com.digitalrepublic.codechallenge.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalrepublic.codechallenge.model.dto.MoneyTransferDTO;
import com.digitalrepublic.codechallenge.model.entities.Account;
import com.digitalrepublic.codechallenge.model.entities.MoneyTransfer;
import com.digitalrepublic.codechallenge.model.repositories.AccountRepository;
import com.digitalrepublic.codechallenge.model.repositories.MoneyTransferRepository;

@Service
public class MoneyTransferService {
    
    @Autowired
    private MoneyTransferRepository moneyTransferRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public MoneyTransferDTO transferMoney(MoneyTransferDTO dto) {
        MoneyTransfer entity = new MoneyTransfer();
        entity.setFromAccountNumber(dto.getFromAccountNumber());
        entity.setToAccountNumber(dto.getToAccountNumber());
        entity.setAmount(dto.getAmount());
        entity.setTransferDate(Instant.now());
        entity.setAccount(dto.getAccount());
        moneyTransferRepository.save(entity);
        return new MoneyTransferDTO(entity);
    }

//    @Transactional
//    public MoneyTransferDTO transferMoney(MoneyTransferDTO transferDto) {
//        Integer fromAccountNumber = transferDto.getFromAccountNumber();
//        Integer toAccountNumber = transferDto.getToAccountNumber();
//        BigDecimal amount = transferDto.getAmount();
//
//        Account fromAccount = accountRepository.findByAccountNumberEquals(fromAccountNumber);
//        Account toAccount = accountRepository.findByAccountNumberEquals(toAccountNumber);
//
////        if(fromAccount.getBalance().compareTo(transferDto.getAmount()) < 0.0) {
////            throw new ResourceNotFoundException("You don't have enough balance to transfer");
////        }
////        if (fromAccount.getBalance().compareTo(transferDto.getAmount()) > 2000.0) {
////            throw new ResourceNotFoundException("You can't transfer more than 2000.00");
////        }
//
//        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
//        accountRepository.save(fromAccount);
//        toAccount.setBalance(toAccount.getBalance().add(amount));
//        accountRepository.save(toAccount);
////        MoneyTransfer moneyTransfer = moneyTransferRepository.save(new MoneyTransfer(null, toAccountNumber, fromAccountNumber, toAccountNumber, amount, Instant.now(), new Account()));
//        MoneyTransfer moneyTransfer = moneyTransferRepository.save(new MoneyTransfer());
//        return new MoneyTransferDTO(moneyTransfer);
//    }
}