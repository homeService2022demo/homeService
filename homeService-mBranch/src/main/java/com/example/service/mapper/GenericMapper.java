package com.example.service.mapper;

import org.springframework.stereotype.Service;

/**
 * @author fh.kazemi
 **/

@Service
public interface GenericMapper<Entity, EntityDto> {

    EntityDto convertToDto(Entity entity);

    Entity convertToEntity(EntityDto entityDto);
}
