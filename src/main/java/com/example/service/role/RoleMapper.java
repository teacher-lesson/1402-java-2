package com.example.service.role;


import com.example.domain.role.Role;
import com.example.dto.role.RoleDto;
import com.example.service.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface RoleMapper extends IMapper<Role, RoleDto, Integer> {

    @Override
    RoleDto toDto(Role entity);

    @Override
    Role toEntity(RoleDto dto);
}
