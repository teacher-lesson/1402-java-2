package com.example.dao.user.impl;

import com.example.dao.user.UserDao;
import com.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

//@Repository
public class UserDaoHibernateImpl implements UserDao {
    @Override
    public void insert(User user) {
        //TODO hibernae code here
    }

    @Override
    public User select(Integer integer) {
        return null;
    }

    @Override
    public Stream<User> selectAll() {
        return null;
    }
}
