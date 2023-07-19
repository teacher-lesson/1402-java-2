package com.example.dto;

public interface IDomainDto<ID extends Number> extends IDto {
    ID getId();
}
