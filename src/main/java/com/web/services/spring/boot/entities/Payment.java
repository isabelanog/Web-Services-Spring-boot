package com.web.services.spring.boot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
@Entity
public class Payment implements Serializable {
    private static final long seriaLVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Instant moment;
    @JsonIgnore
    @OneToOne
    @MapsId
    private Orders order;
    public Payment() {

    }
    public Payment(Long paymentId, Instant moment, Orders order) {
        this.paymentId = paymentId;
        this.moment = moment;
        this.order = order;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return Objects.equals(getPaymentId(), payment.getPaymentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentId());
    }
}
