package com.example.service;

import com.example.dto.IDomainDto;

import java.util.List;

public interface IService<D extends IDomainDto<ID>, ID extends Number> {
    void create(D e);

    D read(ID id);

    List<D> readAll();

    D update(D e);

    void delete(ID id);

    boolean isExist(ID id);
}
