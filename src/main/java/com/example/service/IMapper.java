package com.example.service;

import com.example.domain.IEntity;
import com.example.dto.IDomainDto;

public interface IMapper<E extends IEntity<ID>, D extends IDomainDto<ID>, ID extends Number> {
    D toDto(E entity);

    E toEntity(D dto);
}
