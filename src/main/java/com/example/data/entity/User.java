package com.example.data.entity;

import com.example.data.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20)
    private String name;
    @Column(length = 30)
    private String surname;
    @Column(unique = true, length = 100)
    private String email;
    @Column(length = 20)
    private String username;
    @Column(nullable = false, length = 16)
    private String password;
    @OneToOne
    private Address address;
    @CreationTimestamp
    private Date registerDate;
    @UpdateTimestamp
    private Date modifyDate;
    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
