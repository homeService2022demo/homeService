package com.example.data.dto;

import com.example.data.enums.UserStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
public class CustomerDto extends UserDto {
    private Set<OrderDto> orderDtos;

    @Builder
    public CustomerDto(String name, String surname, String email, String username, String password, AddressDto addressDto, Date registerDate, Date modifyDate, UserStatus status, Set<OrderDto> orderDtos) {
        super(name, surname, email, username, password, addressDto, registerDate, modifyDate, status);
        this.orderDtos = orderDtos;
    }
}
