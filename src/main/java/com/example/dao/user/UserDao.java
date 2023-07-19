package com.example.dao.user;

import com.example.dao.IDao;
import com.example.domain.user.User;

import java.util.List;

public interface UserDao extends IDao<User, Integer> {
    List<User> selectAllWithProp();
    User selectWithProp(Integer id);
}
