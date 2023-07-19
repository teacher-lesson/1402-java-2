package com.example.dao;

import com.example.domain.IEntity;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class BaseDao<E extends IEntity<ID>, ID extends Number> implements IDao<E, ID> {

    protected abstract SessionFactory getSessionFactory();

    protected abstract Class<E> getEntityClass();

    @Override
    @Transactional
    public void insert(E e) {
        var session = getSessionFactory().getCurrentSession();
        session.persist(e);
    }

    @Override
    @Transactional(readOnly = true)
    public E select(ID id) {
        var session = getSessionFactory().getCurrentSession();
        return session.get(getEntityClass(), id);
    }

    @Override
    @Transactional
    public List<E> selectAll() {
        var session = getSessionFactory().getCurrentSession();
        return session.createQuery("from " + getEntityClass().getSimpleName()).getResultList();
    }

    @Override
    @Transactional
    public E modify(E e) {
        var session = getSessionFactory().getCurrentSession();
        return session.merge(e);
    }

    @Override
    @Transactional
    public void remove(ID id) {
        var session = getSessionFactory().getCurrentSession();
        var query = session.createQuery("delete from " + getEntityClass().getSimpleName() + " e where e.id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(ID id) {
        var session = getSessionFactory().getCurrentSession();

        return ((Long) session.createQuery("select count(*) from " + getEntityClass().getSimpleName() + " e where e.id =:id")
                .setParameter("id", id).getSingleResult()) > 0;
    }
}
