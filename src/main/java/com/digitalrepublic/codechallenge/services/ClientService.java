package com.digitalrepublic.codechallenge.services;

import com.digitalrepublic.codechallenge.model.dto.ClientDTO;
import com.digitalrepublic.codechallenge.model.entities.Account;
import com.digitalrepublic.codechallenge.model.entities.Client;
import com.digitalrepublic.codechallenge.model.repositories.ClientRepository;
import com.digitalrepublic.codechallenge.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public ClientDTO create(ClientDTO clientDTO) {
        if (findByCpf(clientDTO) != null) {
            throw new ResourceNotFoundException("Already exists, not acceptable");
        }

        Client client = new Client();

        Account account = new Account();
        account.setClient(client);

        client.setAccount(account);
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());

        clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public Client findByCpf(ClientDTO clientDTO) {
        Client client = clientRepository.findByCpf(clientDTO.getCpf());
        if (client != null) {
            return client;
        }
        return client;
    }
}