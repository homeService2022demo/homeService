package com.example.data.entity;

import com.example.data.enums.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@Entity
@Table(name = "OFFER")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CREATION_DATE")
    @CreationTimestamp
    private Date creationDate;

    @Column(name = "ACCEPTED_DATE")
    private Date acceptedDate;

    @Column(name = "REJECTED_DATE")
    private Date rejectedDate;

    @Column(name = "OFFERED_PRICE")
    private int offeredPrice;

    @OneToOne
    private Expert expert;

    @Column(name = "OFFER_STATUS")
    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;

    @Column(name = "OFFERED_WORK_DURATION")
    private int offeredWorkDuration;

    @Transient
    private LocalDate startDate;

    @Transient
    private LocalTime startTime;

    @Column(name = "DO_DATE")
    private LocalDateTime doDate;

    public void setDoDate() {
        this.doDate = LocalDateTime.of(this.startDate, this.startTime);
    }
}
