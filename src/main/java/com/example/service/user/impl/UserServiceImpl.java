package com.example.service.user.impl;

import com.example.dao.user.UserDao;
import com.example.model.User;
import com.example.service.IService;
import com.example.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {
        userDao.insert(user);
    }

    @Override
    public User read(Integer id) {
        return userDao.select(id);
    }

    @Override
    public Stream<User> readAll() {
        return userDao.selectAll();
    }
}
