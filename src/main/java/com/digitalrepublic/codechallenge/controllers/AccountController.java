package com.digitalrepublic.codechallenge.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.digitalrepublic.codechallenge.model.dto.ClientDTO;
import com.digitalrepublic.codechallenge.model.entities.Client;
import com.digitalrepublic.codechallenge.services.AccountService;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO dto) {
        Client newClient = accountService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(newClient.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}