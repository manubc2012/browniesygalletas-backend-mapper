package com.co.browniesygalletas.persistence.mapper;

import com.co.browniesygalletas.domain.PurchaseDetail;
import com.co.browniesygalletas.persistence.entity.DetalleVenta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseDetailMapper {
    @Mappings({
            @Mapping(source = "idDetalleVenta.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "total", target = "total"),

    })
    PurchaseDetail toPurchaseDetail(DetalleVenta detalleVenta);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "idDetalleVenta.idPedido", ignore = true),
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "idProducto", ignore = true),
    })
    DetalleVenta toDetalleVenta(PurchaseDetail purchaseDetail);
}
