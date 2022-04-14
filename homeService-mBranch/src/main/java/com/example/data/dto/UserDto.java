package com.example.data.dto;

import com.example.data.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;
    private AddressDto addressDto;
    private Double creditCartDto;
    private Date registerDate;
    private Date modifyDate;
    private UserStatus status;
}
