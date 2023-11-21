package com.co.browniesygalletas.domain.service;

import com.co.browniesygalletas.domain.Client;
import com.co.browniesygalletas.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int clientId){
        return clientRepository.getClient(clientId);
    }
}
