package com.example.service;

import com.example.data.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserDto userDto);
}
