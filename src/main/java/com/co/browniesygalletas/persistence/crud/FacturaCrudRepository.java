package com.co.browniesygalletas.persistence.crud;

import com.co.browniesygalletas.persistence.entity.Factura;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FacturaCrudRepository extends CrudRepository<Factura, Long> {

    Optional<List<Factura>> findByIdCliente(String idCliente);
}
