package com.co.browniesygalletas.domain.service;

import com.co.browniesygalletas.domain.Bill;
import com.co.browniesygalletas.domain.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAll(){
        return billRepository.getAll();
    }

    public Optional<List<Bill>> getByClient(String clientId){
        return billRepository.getByClient(clientId);
    }
}
