package com.example.service.user.impl;

import com.example.dao.user.UserDao;
import com.example.domain.user.User;
import com.example.dto.user.UserDto;
import com.example.dto.user.UserLightDto;
import com.example.service.BaseService;
import com.example.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends BaseService<UserDto, User, Integer> implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    protected UserDao getDao() {
        return userDao;
    }

    @Override
    protected UserDto createDto(User user) {
        return new UserDto(user);
    }

    @Override
    public List<UserDto> readAllWithProp() {
        return userDao.selectAllWithProp().stream().map(UserDto::new).collect(Collectors.toList());
    }

    @Override
    public List<UserLightDto> readAllWithoutBook() {
        return getDao().selectAll().stream().map(UserLightDto::new).collect(Collectors.toList());
    }
}
