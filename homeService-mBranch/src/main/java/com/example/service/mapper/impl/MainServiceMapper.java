package com.example.service.mapper.impl;

import com.example.data.dto.MainServiceDto;
import com.example.data.entity.MainService;
import com.example.service.mapper.GenericMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * @author fh.kazemi
 **/

@Data
@Service
public class MainServiceMapper implements GenericMapper<MainService, MainServiceDto> {

    private final SubServiceMapper subServiceMapper;

    @Override
    public MainServiceDto convertToDto(MainService mainService) {
        return MainServiceDto.builder()
                .name(mainService.getName())
                .subServiceDtos(mainService.getSubServices()
                        .stream().map(subServiceMapper::convertToDto)
                        .collect(Collectors.toCollection(HashSet::new)))
                .description(mainService.getDescription())
                .build();
    }

    @Override
    public MainService convertToEntity(MainServiceDto mainServiceDto) {
        return MainService.builder()
                .name(mainServiceDto.getName())
                .subServices(mainServiceDto.getSubServiceDtos()
                        .stream().map(subServiceMapper::convertToEntity)
                        .collect(Collectors.toCollection(HashSet::new)))
                .description(mainServiceDto.getDescription())
                .build();
    }
}
