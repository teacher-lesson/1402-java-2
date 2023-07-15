package org.example.dao.person;

public interface BaseDao<E , ID extends Number> {

    void insert(E e);
}
