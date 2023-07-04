package com.example.service;

import java.util.stream.Stream;

public interface IService<E, ID> {
    void create(E e);
    E read(ID id);
    Stream<E> readAll();
}
