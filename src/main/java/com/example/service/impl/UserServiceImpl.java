package com.example.service.impl;

import com.example.data.dto.UserDto;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public void save(UserDto userDto) {
        //TODO: 1- map to entity 2-check for duplication 3-save if is not duplicate
    }


}
