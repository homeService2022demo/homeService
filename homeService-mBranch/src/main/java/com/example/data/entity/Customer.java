package com.example.data.entity;

import com.example.data.entity.Order;
import com.example.data.enums.UserStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer extends User {
    @OneToMany
    private Set<Order> orders;

    @Builder(builderMethodName = "CustomerBuilder")
    public Customer(Integer id, String name, String surname, String email, String username, String password, Address address, Double creditCart, Date registerDate, Date modifyDate, UserStatus status, Set<Order> orders) {
        super(id, name, surname, email, username, password, address, creditCart, registerDate, modifyDate, status);
        this.orders = orders;
    }
}
