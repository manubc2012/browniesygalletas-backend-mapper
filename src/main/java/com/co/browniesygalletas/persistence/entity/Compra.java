package com.co.browniesygalletas.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;
    @Column(name = "id_cli")
    private String idCliente;
    @Column(name = "fecha_pedido", nullable = false)
    private LocalDate fechaPedido;
    @Column(name = "fecha_entrega_pedido", nullable = false)
    private LocalDate fechaEntregaPedido;
    @Column(name = "direccion_entrega", nullable = false, length = 200)
    private String direccionEntrega;

    @ManyToOne
    @JoinColumn(name = "id_cli", insertable = false, updatable = false)
    private Cliente cliente;

    //LISTA DE PRODUCTOS QUE PERTENECEN A UNA COMPRA
    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
    private List<DetalleVenta> productos;

    @ManyToOne
    @MapsId("idFactura")
    @JoinColumn(name = "id_pedido", insertable = false, updatable = false)
    private Factura factura;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEntregaPedido() {
        return fechaEntregaPedido;
    }

    public void setFechaEntregaPedido(LocalDate fechaEntregaPedido) {
        this.fechaEntregaPedido = fechaEntregaPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public List<DetalleVenta> getProductos() {
        return productos;
    }

    public void setProductos(List<DetalleVenta> productos) {
        this.productos = productos;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }


}
