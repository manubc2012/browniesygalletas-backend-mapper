package com.co.browniesygalletas.persistence.mapper;

import com.co.browniesygalletas.domain.Purchase;
import com.co.browniesygalletas.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseDetailMapper.class, BillMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "idPedido", target = "orderId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fechaPedido", target = "orderDate"),
            @Mapping(source = "fechaEntregaPedido", target = "deliveryDate"),
            @Mapping(source = "direccionEntrega", target = "address"),
            @Mapping(source = "productos", target = "items")
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "cliente", ignore = true),
            @Mapping(target = "factura", ignore = true)
    })
    Compra toCompra(Purchase purchase);
}
