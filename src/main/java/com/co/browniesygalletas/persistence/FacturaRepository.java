package com.co.browniesygalletas.persistence;

import com.co.browniesygalletas.domain.Bill;
import com.co.browniesygalletas.domain.repository.BillRepository;
import com.co.browniesygalletas.persistence.crud.FacturaCrudRepository;
import com.co.browniesygalletas.persistence.entity.Factura;
import com.co.browniesygalletas.persistence.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FacturaRepository implements BillRepository {

    @Autowired
    private FacturaCrudRepository facturaCrudRepository;
    @Autowired
    private BillMapper mapper;

    @Override
    public List<Bill> getAll() {
        return mapper.toBills((List<Factura>) facturaCrudRepository.findAll());
    }

    @Override
    public Optional<List<Bill>> getByClient(String clientId) {
        return facturaCrudRepository.findByIdCliente(clientId)
                .map(facturas -> mapper.toBills(facturas));
    }



}
