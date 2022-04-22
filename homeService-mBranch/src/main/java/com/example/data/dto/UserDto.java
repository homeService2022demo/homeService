package com.example.data.dto;

import com.example.data.enums.UserStatus;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
