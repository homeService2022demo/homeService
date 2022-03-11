package com.example.service.mapper.impl;

import com.example.data.dto.ExpertDto;
import com.example.data.entity.Expert;
import com.example.service.mapper.GenericMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * @author fh.kazemi
 **/
@Data
@Service
public class ExpertMapper implements GenericMapper<Expert, ExpertDto> {

    private final SubServiceMapper subServiceMapper;
    private final AddressMapper addressMapper;

    public ExpertMapper(AddressMapper addressMapper, SubServiceMapper subServiceMapper) {
        this.addressMapper = addressMapper;
        this.subServiceMapper = subServiceMapper;
    }

    @Override
    public ExpertDto convertToDto(Expert expert) {
        return ExpertDto.builder()
                .name(expert.getName())
                .surname(expert.getSurname())
                .username(expert.getUsername())
                .password(expert.getPassword())
                .email(expert.getEmail())
                .addressDto(addressMapper.convertToDto(expert.getAddress()))
                .status(expert.getStatus())
                .registerDate(expert.getRegisterDate())
                .modifyDate(expert.getModifyDate())
                .score(expert.getScore())
                .profileImage(expert.getProfileImage())
                .subServiceDtos(expert.getSubServices()
                        .stream().map(subServiceMapper::convertToDto)
                        .collect(Collectors.toCollection(HashSet::new)))
                .build();
    }

    @Override
    public Expert convertToEntity(ExpertDto expertDto) {
        return Expert.builder()
                .name(expertDto.getName())
                .surname(expertDto.getSurname())
                .username(expertDto.getUsername())
                .password(expertDto.getPassword())
                .email(expertDto.getEmail())
                .address(addressMapper.convertToEntity(expertDto.getAddressDto()))
                .status(expertDto.getStatus())
                .registerDate(expertDto.getRegisterDate())
                .modifyDate(expertDto.getModifyDate())
                .score(expertDto.getScore())
                .profileImage(expertDto.getProfileImage())
                .subServices(expertDto.getSubServiceDtos()
                        .stream().map(subServiceMapper::convertToEntity)
                        .collect(Collectors.toCollection(HashSet::new)))
                .build();
    }
}

