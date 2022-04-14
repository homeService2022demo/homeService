package com.example.data.entity;

import com.example.data.enums.OrderPaymentStatus;
import com.example.data.enums.OrderStatus;
import com.example.data.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CREATION_DATE")
    @CreationTimestamp
    private Date creationDate;

    @Column(name = "ORDER_STATUS")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderstatus;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;

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

    @OneToMany(mappedBy = "order")
    private Set<Offer> offers;

    @Column(name = "DESCRIPTION", length = 5000)
    private String description;
}
