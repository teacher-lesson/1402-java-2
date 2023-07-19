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

    protected abstract IMapper<E, D, ID> getMapper();

    public boolean isExist(ID id) {
        return getDao().isExist(id);
    }

    @Override
    public void create(D d) {
        getDao().insert(getMapper().toEntity(d));
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

        return getMapper().toDto(getDao().select(id));
    }

    @Override
    public List<D> readAll() {
        return getDao().selectAll().stream()
                .map(x -> getMapper().toDto(x)).collect(Collectors.toList());
    }

    @Override
    public D update(D d) {
        if (d == null || d.getId() == null) {
            throw new ResponseException(400);
        }

        if (!isExist(d.getId())) {
            throw new ResponseException(404);
        }

        return getMapper().toDto(getDao().modify(getMapper().toEntity(d)));
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
