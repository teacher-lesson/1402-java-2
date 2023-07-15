package org.example.dao;

import java.io.Serializable;
import java.util.List;

public abstract class BaseDaoImpl<E extends Serializable, ID extends Number> implements BaseDao<E, ID> {

    protected abstract HibernateHelper getHelper();

    protected abstract Class<E> getEntityClass();

    @Override
    public void insert(E e) {
        final var session = getHelper().getSession();
        final var tx = session.beginTransaction();

        session.persist(e);

        tx.commit();
    }

    @Override
    public E select(ID id) {
        final var session = getHelper().getSession();
        final var tx = session.beginTransaction();

        final E e = session.get(getEntityClass(), id);

        tx.commit();

        return e;
    }

    @Override
    public List<E> select() {
        final var session = getHelper().getSession();
        final var tx = session.beginTransaction();

        final List<E> es = session.createQuery("from " + getEntityClass().getSimpleName()).getResultList();

        tx.commit();

        return es;
    }

    @Override
    public E modify(E e) {
        final var session = getHelper().getSession();
        final var tx = session.beginTransaction();

        final E merge = session.merge(e);

        tx.commit();

        return merge;
    }

    @Override
    public void remove(ID id) {
        final var session = getHelper().getSession();
        final var tx = session.beginTransaction();

        session.createQuery("delete from " + getEntityClass().getSimpleName() + " x where x.id =" + id);

        tx.commit();
    }
}
