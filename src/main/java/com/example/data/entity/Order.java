package com.example.data.entity;

import com.example.data.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private Date creationDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderstatus;
    @Enumerated(EnumType.STRING)
    private OrderPaymentStatus orderPaymentStatus;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @OneToOne
    private Work work;
    @Column(length = 5000)
    private String description;
    @OneToMany
    private Set<Offer> offers;



}
