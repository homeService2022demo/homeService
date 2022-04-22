package com.example.service.mapper.impl;

import com.example.data.dto.AddressDto;
import com.example.data.entity.Address;
import com.example.service.mapper.GenericMapper;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class AddressMapper implements GenericMapper<Address, AddressDto> {

    @Override
    public AddressDto convertToDto(Address address) {
        return AddressDto.builder()
                .province(address.getProvince())
                .city(address.getCity())
                .street(address.getStreet())
                .alley(address.getAlley())
                .no(address.getNo())
                .zipcode(address.getZipcode())
                .unitNumber(address.getUnitNumber())
                .build();
    }

    @Override
    public Address convertToEntity(AddressDto addressDto) {
        return Address.builder()
                .province(addressDto.getProvince())
                .city(addressDto.getCity())
                .street(addressDto.getStreet())
                .alley(addressDto.getAlley())
                .no(addressDto.getNo())
                .zipcode(addressDto.getZipcode())
                .unitNumber(addressDto.getUnitNumber())
                .build();
    }
}
