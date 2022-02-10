package com.example.service.mapper;

import com.example.data.dto.UserDto;
import com.example.data.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;
    private final AddressMapper addressMapper;

    public UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
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

    public User convertToEntity() {
        User user;
        //TODO
        return null;
    }

}
