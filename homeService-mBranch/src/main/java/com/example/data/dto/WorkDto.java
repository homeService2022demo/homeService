package com.example.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkDto {
    private Date startDate;
    private Date finishedDate;
    private SubServiceDto subServiceDto;
}
