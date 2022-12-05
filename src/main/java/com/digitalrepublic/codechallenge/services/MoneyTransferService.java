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
//        pega o id da conta que quer que saia o dinheiro, subtrai a quantia e salva
        Account account1 = accountRepository.findById(dto.getFromAccountNumber()).get();
        BigDecimal currentBalance1 = account1.getBalance().subtract(dto.getAmount());
        account1.setBalance(currentBalance1);
        accountRepository.save(account1);
//        pega o id da conta que recebe o dinheiro, adiciona ao saldo e salva
        Account account2 = accountRepository.findById(dto.getToAccountNumber()).get();
        BigDecimal currentBalance2 = account2.getBalance().add(dto.getAmount());
        account2.setBalance(currentBalance2);
        accountRepository.save(account2);
//        manda os dados pra requisição
        MoneyTransfer entity = new MoneyTransfer();
        entity.setFromAccountNumber(dto.getFromAccountNumber());
        entity.setToAccountNumber(dto.getToAccountNumber());
        entity.setAmount(dto.getAmount());
        entity.setTransferDate(Instant.now());
        moneyTransferRepository.save(entity);

        //        valida se a conta tem saldo pra fazer a transferencia
        if (currentBalance1.doubleValue() < 0.00) {
            throw new BalanceCantCompleteException("You can't have negative balance");
        }
//        valida se a transferencia é menor que 2000.00
        if(entity.getAmount().doubleValue() > 2000.00) {
            throw new CantCompleteException("You can't transfer more than $ 2000.00");
        }
        return new MoneyTransferDTO(entity);
    }
}