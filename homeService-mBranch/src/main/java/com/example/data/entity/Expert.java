package com.example.data.entity;

import com.example.data.enums.UserStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "EXPERT")
public class Expert extends User {
    @Column(name = "SCORE")
    private double score;

    @Column(name = "PROFILE_IMAGE", columnDefinition = "BLOB")
    private byte[] profileImage;

    @ManyToMany
    private Set<SubService> subServices;

    @Builder
    public Expert(int id, String name, String surname, String email, String username, String password, Address address, Date registerDate, Date modifyDate, UserStatus status, double score, byte[] profileImage, Set<SubService> subServices) {
        super(id, name, surname, email, username, password, address, registerDate, modifyDate, status);
        this.score = score;
        this.profileImage = profileImage;
        this.subServices = subServices;
    }
}
