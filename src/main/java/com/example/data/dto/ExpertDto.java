package com.example.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpertDto {
    private double score;
    private byte[] profileImage;
    private Set<SubServiceDto> subServiceDtos;
}
