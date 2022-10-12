package com.digitalrepublic.codechallenge.services;

import com.digitalrepublic.codechallenge.model.dto.MoneyTransferDTO;
import com.digitalrepublic.codechallenge.model.entities.MoneyTransfer;
import com.digitalrepublic.codechallenge.model.repositories.AccountRepository;
import com.digitalrepublic.codechallenge.model.repositories.MoneyTransferRepository;
import com.digitalrepublic.codechallenge.services.exceptions.CantCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

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
        if(entity.getAmount().doubleValue() > 2000.00) {
            throw new CantCompleteException("You can't transfer more than $ 2000.00");
        }
        return new MoneyTransferDTO(entity);
    }
}