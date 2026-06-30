package org.example.projectwebservicesection22.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant paymentDate;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Order order;

    public Payment(Long id, Instant paymentDate, Order order) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.order = order;
    }

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(paymentDate, payment.paymentDate) && Objects.equals(order, payment.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentDate, order);
    }
}
