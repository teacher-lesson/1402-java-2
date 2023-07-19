package com.example.dao.role.impl;

import com.example.dao.BaseDao;
import com.example.dao.role.RoleDao;
import com.example.domain.role.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends BaseDao<Role, Integer> implements RoleDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }
}
