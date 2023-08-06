package com.example.dao.user.impl;

import com.example.dao.BaseDao;
import com.example.dao.user.UserDao;
import com.example.domain.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDao<User, Integer> implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> selectAllWithProp() {
        return entityManager.createQuery("from User u left join fetch u.books left join fetch u.roles").getResultList(); // JQL
    }

    @Override
    @Transactional(readOnly = true)
    public User selectWithProp(Integer id) {
        return (User) entityManager.createQuery("from User u left join fetch u.books left join fetch u.roles where u.id = :id")
                .setParameter("id", id).getSingleResult();
    }
}
