package com.co.browniesygalletas.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long idFactura;

    @Column(name = "id_cli")
    private String idCliente;

    @Column(name = "total_facturacion", nullable = false)
    private double totalFacturacion;

    @Column(name = "id_Pedido")
    private String idCompra;

    @ManyToOne
    @JoinColumn(name = "id_cli", insertable = false, updatable = false)
    private Cliente cliente;

    @OneToMany
    @JoinColumn(name = "id_Pedido", insertable = false, updatable = false)
    private List<Compra> pedido;

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public double getTotalFacturacion() {
        return totalFacturacion;
    }

    public void setTotalFacturacion(double totalFacturacion) {
        this.totalFacturacion = totalFacturacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public List<Compra> getPedido() {
        return pedido;
    }

    public void setPedido(List<Compra> pedido) {
        this.pedido = pedido;
    }

}

