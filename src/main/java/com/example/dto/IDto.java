package com.example.dto;

import com.example.domain.IEntity;

import java.io.Serializable;

public interface IDto<ID extends Number> extends Serializable {
    ID getId();
    IEntity<ID> toEntity();
}
