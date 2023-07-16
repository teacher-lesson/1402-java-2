package com.example.dao;

import com.example.domain.IEntity;

import java.io.Serializable;
import java.util.List;

public interface IDao<E extends IEntity<ID>, ID extends Number> {
    void insert(E e);
    E select(ID id);
    List<E> selectAll();
    E modify(E e);
    void remove(ID id);
}
