package com.example.dao;

import com.example.domain.IEntity;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class BaseDao<E extends IEntity<ID>, ID extends Number> implements IDao<E, ID> {

    protected abstract EntityManager getEntityManager();

    protected abstract Class<E> getEntityClass();

    @Override
    @Transactional
    public void insert(E e) {
        getEntityManager().persist(e);
    }

    @Override
    @Transactional(readOnly = true)
    public E select(ID id) {
        return getEntityManager().find(getEntityClass(), id);
    }

    @Override
    @Transactional
    public List<E> selectAll() {
        return getEntityManager().createQuery("From " + getEntityClass().getSimpleName()).getResultList();
    }

    @Override
    @Transactional
    public E modify(E e) {
        return getEntityManager().merge(e);
    }

    @Override
    @Transactional
    public void remove(ID id) {
        var query = getEntityManager().createQuery("delete from " + getEntityClass().getSimpleName() + " e where e.id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(ID id) {
        return ((Long) getEntityManager().createQuery("select count(*) from " + getEntityClass().getSimpleName() + " e where e.id =:id")
                .setParameter("id", id).getSingleResult()) > 0;
    }
}
