package com.example.service.mapper.impl;

import com.example.data.dto.CustomerDto;
import com.example.data.entity.Customer;
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
public class CustomerMapper implements GenericMapper<Customer, CustomerDto> {

    private final AddressMapper addressMapper;
    private final OrderMapper orderMapper;

    @Override
    public CustomerDto convertToDto(Customer customer) {
        return CustomerDto.builder()
                .name(customer.getName())
                .surname(customer.getSurname())
                .username(customer.getUsername())
                .password(customer.getPassword())
                .email(customer.getEmail())
                .addressDto(addressMapper.convertToDto(customer.getAddress()))
                .status(customer.getStatus())
                .registerDate(customer.getRegisterDate())
                .modifyDate(customer.getModifyDate())
                .orderDtos(customer.getOrders()
                        .stream().map(orderMapper::convertToDto)
                        .collect(Collectors.toCollection(HashSet::new)))
                .build();
    }

    @Override
    public Customer convertToEntity(CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.getName())
                .surname(customerDto.getSurname())
                .username(customerDto.getUsername())
                .password(customerDto.getPassword())
                .email(customerDto.getEmail())
                .address(addressMapper.convertToEntity(customerDto.getAddressDto()))
                .status(customerDto.getStatus())
                .registerDate(customerDto.getRegisterDate())
                .modifyDate(customerDto.getModifyDate())
                .orders(customerDto.getOrderDtos()
                        .stream().map(orderMapper::convertToEntity)
                        .collect(Collectors.toCollection(HashSet::new)))
                .build();
    }
}
