package com.example.service.user;

import com.example.MyWebInit;
import com.example.domain.user.User;
import com.example.dto.user.UserDto;
import com.example.dto.user.UserFullDto;
import com.example.service.IMapper;
import com.example.service.role.RoleMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = RoleMapper.class)
public interface UserMapper extends IMapper<User, UserDto, Integer> {

    @Mapping(source = "roles", target = "roles")
    @Mapping(target = "fullname", expression = "java(user.getFirstName() + user.getLastName())")
    UserFullDto toFullDto(User user);

    User toFullUser(UserFullDto dto);
}
