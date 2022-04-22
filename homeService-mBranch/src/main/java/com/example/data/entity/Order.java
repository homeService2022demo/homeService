package com.example.data.entity;

import com.example.data.enums.OrderPaymentStatus;
import com.example.data.enums.OrderStatus;
import com.example.data.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ORDER_TRACKING_CODE")
    private String orderTackingCode;//random alpha-numeric string

    @Column(name = "CREATION_DATE")
    @CreationTimestamp
    private Date creationDate;

    @Column(name = "ORDER_STATUS")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderstatus;

    @ManyToOne
    private SubService subService;

    @Column(name = "ORDER_PAYMENT_STATUS")
    @Enumerated(EnumType.STRING)
    private OrderPaymentStatus orderPaymentStatus;

    @Column(name = "PAYMENT_TYPE")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @OneToOne
    private Work work;

    @OneToMany
    private Set<Offer> offers;

    @Column(name = "DESCRIPTION", length = 5000)
    private String description;

    public Order() {
        setOrderTackingCode();
    }

    public void setOrderTackingCode() {
        this.orderTackingCode = TackingCode.generate();
    }
}
