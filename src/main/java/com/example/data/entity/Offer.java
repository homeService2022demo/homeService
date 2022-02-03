package com.example.data.entity;

import com.example.data.enums.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private Date creationDate;
    private Date acceptedDate;
    private Date rejectedDate;
    private int offeredPrice;
    @OneToOne
    private Expert expert;
    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;
    private int offeredWorkDuration;
    @Transient
    private LocalDate startDate;
    @Transient
    private LocalTime startTime;
    private LocalDateTime doDate;

    public void setDoDate() {
        this.doDate = LocalDateTime.of(startDate, startTime);
    }
}
