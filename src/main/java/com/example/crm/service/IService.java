package com.example.crm.service;

import com.example.crm.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

public interface IService<E extends BaseEntity<ID>, ID extends Number> {
    void create(E e);
    E read(ID id);
    Stream<E> readAll();
    void modify(ID id, E e);
    void remove(ID id);
}
