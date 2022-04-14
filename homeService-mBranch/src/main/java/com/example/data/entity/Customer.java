package com.example.data.entity;

import com.example.data.enums.UserStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer extends User {
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    @Builder
    public Customer(int id, String name, String surname, String email, String username, String password, Address address,Double creditCart, Date registerDate, Date modifyDate, UserStatus status, Set<Order> orders) {
        super(id, name, surname, email, username, password, address, creditCart, registerDate, modifyDate, status);
        this.orders = orders;
    }
}
