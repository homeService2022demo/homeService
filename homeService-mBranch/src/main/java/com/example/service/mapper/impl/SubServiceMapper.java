package com.example.service.mapper.impl;

import com.example.data.dto.SubServiceDto;
import com.example.data.entity.SubService;
import com.example.service.mapper.GenericMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author fh.kazemi
 **/

@Data
@Service
public class SubServiceMapper implements GenericMapper<SubService, SubServiceDto> {

    @Override
    public SubServiceDto convertToDto(SubService subService) {
        return SubServiceDto.builder()
                .name(subService.getName())
                .basePrice(subService.getBasePrice())
                .description(subService.getDescription())
                .build();
    }

    @Override
    public SubService convertToEntity(SubServiceDto subServiceDto) {
        return SubService.builder()
                .name(subServiceDto.getName())
                .basePrice(subServiceDto.getBasePrice())
                .description(subServiceDto.getDescription())
                .build();
    }
}
