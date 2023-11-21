package com.co.browniesygalletas.domain.repository;

import com.co.browniesygalletas.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> getAll();

    Optional<Client> getClient(int clientId);
}
