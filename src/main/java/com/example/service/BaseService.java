package com.example.service;

import com.example.dao.IDao;
import com.example.domain.IEntity;
import com.example.dto.IDto;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseService<D extends IDto<ID>, E extends IEntity<ID>, ID extends Number> implements IService<D, ID> {
    protected abstract IDao<E, ID> getDao();

    protected abstract IDto<ID> createDto(E e);

    @Override
    public void create(D d) {
        getDao().insert((E) d.toEntity());
    }

    @Override
    public D read(ID id) {
        return (D) createDto(getDao().select(id));
    }

    @Override
    public List<D> readAll() {
        return (List<D>) getDao().selectAll().stream()
                .map(x -> createDto(x)).collect(Collectors.toList());
    }

    @Override
    public D update(D e) {
        return (D) createDto(getDao().modify((E) e.toEntity()));
    }

    @Override
    public void delete(ID id) {
        getDao().remove(id);
    }
}
