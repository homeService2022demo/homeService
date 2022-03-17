package com.example.service.mapper.impl;

import com.example.data.dto.WorkDto;
import com.example.data.entity.Work;
import com.example.service.mapper.GenericMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author fh.kazemi
 **/

@Data
@Service
@AllArgsConstructor
public class WorkMapper implements GenericMapper<Work, WorkDto> {

    private final SubServiceMapper subServiceMapper;

    @Override
    public WorkDto convertToDto(Work work) {
        return WorkDto.builder()
                .startDate(work.getStartDate())
                .finishedDate(work.getFinishedDate())
                .subServiceDto(subServiceMapper.convertToDto(work.getSubService()))
                .build();
    }

    @Override
    public Work convertToEntity(WorkDto workDto) {
        return Work.builder()
                .startDate(workDto.getStartDate())
                .finishedDate(workDto.getFinishedDate())
                .subService(subServiceMapper.convertToEntity(workDto.getSubServiceDto()))
                .build();
    }
}
