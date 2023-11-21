package com.co.browniesygalletas.domain;

import java.time.LocalDate;
import java.util.List;

public class Purchase {
    private Long orderId;
    private String clientId;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String address;
    private List<PurchaseDetail> items;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PurchaseDetail> getItems() {
        return items;
    }

    public void setItems(List<PurchaseDetail> items) {
        this.items = items;
    }
}
