package com.example.domain;

import java.io.Serializable;

public interface IEntity<ID extends Number> extends Serializable {
    ID getId();
}
