package com.co.browniesygalletas.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @EmbeddedId
    private DetalleVentaPK idDetalleVenta;
    @Column(name = "cantidad_producto")
    private int cantidad;
    private Double total;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedi", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Producto idProducto;

    public DetalleVentaPK getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(DetalleVentaPK idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Compra getIdPedido() {
        return compra;
    }

    public void setIdPedido(Compra idCompra) {
        this.compra = idCompra;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra idCompra) {
        this.compra = idCompra;
    }
}
