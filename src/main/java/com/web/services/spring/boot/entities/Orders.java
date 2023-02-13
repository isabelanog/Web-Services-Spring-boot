package com.web.services.spring.boot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.services.spring.boot.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {
    private static final long seriaLVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private Integer orderStatus;
    @ManyToOne
    @JoinColumn(name = "client_id") //chave estrangeira
    private Users client;

    public Orders() {
    }
    public Orders(Long orderID, Instant moment, OrderStatus orderStatus, Users client) {
        this.orderID = orderID;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }
    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
    }
    public Users getClient() {
        return client;
    }
    public void setClient(Users client) {
        this.client = client;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders orders)) return false;
        return Objects.equals(getOrderID(), orders.getOrderID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderID());
    }
}
