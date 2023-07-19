package com.example.service.user;

import com.example.dto.user.UserDto;
import com.example.dto.user.UserFullDto;
import com.example.service.IService;

import java.util.List;

public interface UserService extends IService<UserDto, Integer> {
    List<UserDto> readAllWithProp();

    List<UserFullDto> readAllWithoutBook();
}
