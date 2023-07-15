package org.example.service;

import org.example.dao.BaseDao;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<E extends Serializable, ID extends Number> implements BaseService<E, ID> {

    protected abstract BaseDao<E, ID> getDao();

    @Override
    public void create(E e) {
        getDao().insert(e);
    }

    @Override
    public E read(ID id) {
        return getDao().select(id);
    }

    @Override
    public List<E> read() {
        return getDao().select();
    }

    @Override
    public E update(E e) {
        return getDao().modify(e);
    }

    @Override
    public void delete(ID id) {
        getDao().remove(id);
    }
}
