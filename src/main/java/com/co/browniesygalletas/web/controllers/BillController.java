package com.co.browniesygalletas.web.controllers;

import com.co.browniesygalletas.domain.Bill;
import com.co.browniesygalletas.domain.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/list")
    public ResponseEntity<List<Bill>> getAll(){
        return new ResponseEntity<>(billService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Bill>> getByClient(@PathVariable("id")String clientId){
        return billService.getByClient(clientId).map(bills -> new ResponseEntity<>(bills, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
