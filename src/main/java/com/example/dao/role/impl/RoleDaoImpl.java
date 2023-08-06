package com.example.dao.role.impl;

import com.example.dao.BaseDao;
import com.example.dao.role.RoleDao;
import com.example.domain.role.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends BaseDao<Role, Integer> implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }
}
