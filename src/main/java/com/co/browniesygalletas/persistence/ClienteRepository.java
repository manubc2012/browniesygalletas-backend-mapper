package com.co.browniesygalletas.persistence;

import com.co.browniesygalletas.domain.Client;
import com.co.browniesygalletas.domain.repository.ClientRepository;
import com.co.browniesygalletas.persistence.crud.ClienteCrudRepository;
import com.co.browniesygalletas.persistence.entity.Cliente;
import com.co.browniesygalletas.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    @Autowired
    private ClientMapper mapper;

    @Override
    public List<Client> getAll() {
        List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
        return mapper.toClients(clientes);
    }

    @Override
    public Optional<Client> getClient(int clientId) {
        return clienteCrudRepository.findById((long)clientId).map(cliente -> mapper.toClient(cliente));
    }
}
