package com.example.dao.user.impl;

import com.example.dao.BaseDao;
import com.example.dao.user.UserDao;
import com.example.domain.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDao<User, Integer> implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> selectAllWithProp() {
        var session = sessionFactory.getCurrentSession();
        return session.createQuery("from User u left join fetch u.books").getResultList();
    }
}
