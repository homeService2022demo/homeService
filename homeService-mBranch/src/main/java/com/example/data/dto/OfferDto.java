package com.example.data.dto;

import com.example.data.entity.Order;
import com.example.data.enums.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferDto {
    private Date creationDate;
    private Date acceptedDate;
    private Date rejectedDate;
    private int offeredPrice;
    private ExpertDto expert;
    private OfferStatus offerStatus;
    private int offeredWorkDuration;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDateTime doDate;

    public void setDoDate() {
        this.doDate = LocalDateTime.of(startDate, startTime);
    }
}
