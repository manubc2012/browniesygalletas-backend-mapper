package com.co.browniesygalletas.persistence.mapper;

import com.co.browniesygalletas.domain.Bill;
import com.co.browniesygalletas.persistence.entity.Factura;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseMapper.class})
public interface BillMapper {
    @Mappings({
            @Mapping(source = "idFactura", target = "billId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "totalFacturacion", target = "total"),
            @Mapping(source = "pedido", target = "purchases"),

    })
    Bill toBill(Factura factura);

    List<Bill> toBills(List<Factura> facturas);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Factura toFactura(Bill bill);
}
