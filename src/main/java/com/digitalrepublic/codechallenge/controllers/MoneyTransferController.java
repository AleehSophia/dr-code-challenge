package com.digitalrepublic.codechallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalrepublic.codechallenge.model.dto.MoneyTransferDTO;
import com.digitalrepublic.codechallenge.services.MoneyTransferService;

@RestController
@RequestMapping(value = "/transfer")
public class MoneyTransferController {
    
    @Autowired
    private MoneyTransferService transferService;

    @PostMapping
    public ResponseEntity<MoneyTransferDTO> transferMoney(@RequestBody MoneyTransferDTO transferDTO) {
        transferDTO = transferService.transferMoney(transferDTO);
        return ResponseEntity.ok().body(transferDTO);
    }
}