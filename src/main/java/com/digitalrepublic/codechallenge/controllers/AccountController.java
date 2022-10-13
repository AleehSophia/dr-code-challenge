package com.digitalrepublic.codechallenge.controllers;

import com.digitalrepublic.codechallenge.model.dto.AccountDTO;
import com.digitalrepublic.codechallenge.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController implements Serializable {

    @Autowired
    private AccountService service;

    @PostMapping
    public ResponseEntity<AccountDTO> deposit(@RequestBody AccountDTO dto) {
        dto = service.deposit(dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> firstDeposit(@RequestBody AccountDTO dto) {
        dto = service.firstDeposit(dto);
        return ResponseEntity.ok().body(dto);
    }
}