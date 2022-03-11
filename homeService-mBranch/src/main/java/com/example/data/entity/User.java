package com.example.data.entity;

import com.example.data.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "SURNAME", length = 30)
    private String surname;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "USERNAME", nullable = false, length = 20)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 16)
    private String password;

    @OneToOne
    private Address address;

    @Column(name = "REGISTER_DATE")
    @CreationTimestamp
    private Date registerDate;

    @Column(name = "MODIFY_DATE")
    @UpdateTimestamp
    private Date modifyDate;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
