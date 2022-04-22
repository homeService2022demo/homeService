package com.example.service.mapper.impl;

import com.example.data.dto.UserDto;
import com.example.data.entity.User;
import com.example.service.mapper.GenericMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author fh.kazemi
 **/

@Data
@Service
public class UserMapper implements GenericMapper<User, UserDto> {

    private AddressMapper addressMapper;

    @Override
    public UserDto convertToDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .addressDto(addressMapper.convertToDto(user.getAddress()))
                .status(user.getStatus())
                .registerDate(user.getRegisterDate())
                .modifyDate(user.getModifyDate())
                .build();
    }

    @Override
    public User convertToEntity(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .address(addressMapper.convertToEntity(userDto.getAddressDto()))
                .registerDate(userDto.getRegisterDate())
                .modifyDate(userDto.getModifyDate())
                .status(userDto.getStatus())
                .build();
    }
}
