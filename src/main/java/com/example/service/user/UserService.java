package com.example.service.user;

import com.example.dao.user.UserDao;
import com.example.model.User;
import com.example.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class UserService implements IService<User, Integer> {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
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
