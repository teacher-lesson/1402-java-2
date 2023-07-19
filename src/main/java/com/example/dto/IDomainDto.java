package com.example.dto;

import com.example.domain.IEntity;

public interface IDomainDto<ID extends Number> extends IDto {
    ID getId();
    IEntity<ID> toEntity();
}
