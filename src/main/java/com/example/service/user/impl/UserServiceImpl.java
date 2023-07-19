package com.example.service.user.impl;

import com.example.dao.user.UserDao;
import com.example.domain.user.User;
import com.example.dto.user.UserDto;
import com.example.dto.user.UserFullDto;
import com.example.service.BaseService;
import com.example.service.user.UserMapper;
import com.example.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<UserDto, User, Integer> implements UserService {

    private final UserDao userDao;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Override
    protected UserDao getDao() {
        return userDao;
    }

    @Override
    protected UserMapper getMapper() {
        return userMapper;
    }

    @Override
    public UserFullDto readFullById(Integer id) {
        return getMapper().toFullDto(getDao().selectWithProp(id));
    }
}
