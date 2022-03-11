package com.example.service.mapper.impl;

import com.example.data.dto.AdminDto;
import com.example.data.entity.Admin;
import com.example.service.mapper.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author fh.kazemi
 **/

@Service
@RequiredArgsConstructor
public class AdminMapper implements GenericMapper<Admin, AdminDto> {

    @Override
    public AdminDto convertToDto(Admin admin) {
        return AdminDto.builder().build();
    }

    @Override
    public Admin convertToEntity(AdminDto adminDto) {
        return Admin.builder().build();
    }
}
