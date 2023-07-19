package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;


@JsonInclude(NON_NULL)
public interface IDto extends Serializable {
}
