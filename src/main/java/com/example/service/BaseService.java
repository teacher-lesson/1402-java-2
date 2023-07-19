package com.example.service;

import com.example.core.exception.ResponseException;
import com.example.dao.IDao;
import com.example.domain.IEntity;
import com.example.dto.IDomainDto;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public abstract class BaseService<D extends IDomainDto<ID>, E extends IEntity<ID>, ID extends Number> implements IService<D, ID> {
    protected abstract IDao<E, ID> getDao();

    protected abstract IDomainDto<ID> createDto(E e);

    public boolean isExist(ID id) {
        return getDao().isExist(id);
    }

    @Override
    public void create(D d) {
        getDao().insert((E) d.toEntity());
    }

    @Override
    public D read(ID id) {
        if (id == null) {
            throw new ResponseException("Id not found", BAD_REQUEST);
        }

        if (!isExist(id)) {
            throw new ResponseException("Entity not found", NOT_FOUND);
//            throw new ResponseException(NOT_FOUND);
        }

        return (D) createDto(getDao().select(id));
    }

    @Override
    public List<D> readAll() {
        return (List<D>) getDao().selectAll().stream()
                .map(x -> createDto(x)).collect(Collectors.toList());
    }

    @Override
    public D update(D e) {
        if (e == null || e.getId() == null) {
            throw new ResponseException(400);
        }

        if (!isExist(e.getId())) {
            throw new ResponseException(404);
        }

        return (D) createDto(getDao().modify((E) e.toEntity()));
    }

    @Override
    public void delete(ID id) {
        if (id == null) {
            throw new ResponseException(400);
        }

        if (!isExist(id)) {
            throw new ResponseException(404);
        }

        getDao().remove(id);
    }
}
