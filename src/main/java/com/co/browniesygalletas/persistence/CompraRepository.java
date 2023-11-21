package com.co.browniesygalletas.persistence;

import com.co.browniesygalletas.domain.Purchase;
import com.co.browniesygalletas.domain.repository.PurchaseRepository;
import com.co.browniesygalletas.persistence.crud.CompraCrudRepository;
import com.co.browniesygalletas.persistence.entity.Compra;
import com.co.browniesygalletas.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return (Purchase) mapper.toPurchases((List<Compra>) compraCrudRepository.save(compra));
    }
}
