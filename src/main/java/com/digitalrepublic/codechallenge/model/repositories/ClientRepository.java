package com.digitalrepublic.codechallenge.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.digitalrepublic.codechallenge.model.entities.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByCpf(String cpf);
}