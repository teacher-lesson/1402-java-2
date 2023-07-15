package org.example.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<E extends Serializable, ID extends Number> {

    void insert(E e);

    E select(ID id);

    List<E> select();

    E modify(E e);

    void remove(ID id);

}
