package com.web.services.spring.boot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.services.spring.boot.entities.pk.OrderItemPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;
@Entity
public class OrderItem implements Serializable {
    private static final long seriaLVersionUID = 1L;
    @EmbeddedId //id composto -> tem que instanciar
    private OrderItemPk id = new OrderItemPk();
    private Integer quantity;
    private double price;

    public OrderItem() {

    }
    public OrderItem(Orders orders, Product product, Integer quantity, double price) {
        super();
        id.setOrders(orders);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    @JsonIgnore
    public Orders getOrder() {
        return id.getOrders();
    }
    public void setOrder(Orders orders) {
        id.setOrders(orders);
    }
    public Product getProduct() {
        return id.getProduct();
    }
    public void setProduct(Product product) {
        id.setProduct(product);
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public Double getSubTotal() {
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem orderItem)) return false;
        return Objects.equals(id, orderItem.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
