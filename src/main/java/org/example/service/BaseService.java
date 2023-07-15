package org.example.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Serializable, ID extends Number> {

    void create(E e);

    E read(ID id);

    List<E> read();

    E update(E e);

    void delete(ID id);
}
