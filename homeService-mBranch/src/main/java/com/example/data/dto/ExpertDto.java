package com.example.data.dto;

import com.example.data.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
public class ExpertDto extends UserDto{
    private double score;
    private byte[] profileImage;
    private Set<SubServiceDto> subServiceDtos;

    @Builder
    public ExpertDto(String name, String surname, String email, String username, String password, AddressDto addressDto,Double creditCart, Date registerDate, Date modifyDate, UserStatus status, double score, byte[] profileImage, Set<SubServiceDto> subServiceDtos) {
        super(name, surname, email, username, password, addressDto,creditCart, registerDate, modifyDate, status);
        this.score = score;
        this.profileImage = profileImage;
        this.subServiceDtos = subServiceDtos;
    }
}
