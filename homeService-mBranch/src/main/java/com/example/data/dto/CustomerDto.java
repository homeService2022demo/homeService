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
    private Set<CommentDto> commentDtos;

    @Builder
    public CustomerDto(String name, String surname, String email, String username, String password, AddressDto addressDto, Double creditCart, Date registerDate, Date modifyDate, UserStatus status, Set<OrderDto> orderDtos, Set<CommentDto> commentDtos) {
        super(name, surname, email, username, password, addressDto, creditCart, registerDate, modifyDate, status);
        this.orderDtos = orderDtos;
        this.commentDtos = commentDtos;
    }
}
