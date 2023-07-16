package com.example.service;

import com.example.dto.IDto;

import java.util.List;

public interface IService<D extends IDto, ID extends Number> {
    void create(D e);
    D read(ID id);
    List<D> readAll();
    D update(D e);
    void delete(ID id);
}
