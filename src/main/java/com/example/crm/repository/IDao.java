package com.example.crm.repository;

import com.example.crm.domain.BaseEntity;
import com.example.crm.domain.customer.Customer;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

public interface IDao<E extends BaseEntity<ID>, ID extends Number> {
    E select(ID id);
    void insert(E e);
    void update(ID id, E e);
    void delete(ID id);
    Stream<E> selectAll();
}
