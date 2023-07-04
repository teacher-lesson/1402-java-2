package com.example.dao;

import java.util.stream.Stream;

public interface Dao<E, ID> {

    void insert(E e);

//    void delete(ID id);

//    void update(ID id, E e);

    E select(ID id);
    Stream<E> selectAll();
}
