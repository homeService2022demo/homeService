package com.example.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SUB_SERVICE")
public class SubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="NAME",length = 20)
    private String name;

    @Column(name="BASE_PRICE",length = 20)
    private int basePrice;

    @Column(name="DESCRIPTION",length = 5000)
    private String description;
}
