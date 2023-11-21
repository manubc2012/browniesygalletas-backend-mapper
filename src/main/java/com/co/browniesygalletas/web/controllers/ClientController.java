package com.co.browniesygalletas.web.controllers;

import com.co.browniesygalletas.domain.Client;
import com.co.browniesygalletas.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public ResponseEntity<List<Client>> getAll(){
        List<Client> clientList = clientService.getAll();
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id")int clientId){
        return clientService.getClient(clientId).map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
