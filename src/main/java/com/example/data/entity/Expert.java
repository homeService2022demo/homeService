package com.example.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expert extends User {
    private double score;
    @Column(columnDefinition = "BLOB")
    private byte[] profileImage;
    @ManyToMany
    private Set<SubService> subServices;

}
