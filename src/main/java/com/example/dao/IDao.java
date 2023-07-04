package com.example.dao;

import java.util.stream.Stream;

public interface IDao<E, ID> {

    void insert(E e);

//    void delete(ID id);

//    void update(ID id, E e);

    E select(ID id);
    Stream<E> selectAll();
}
