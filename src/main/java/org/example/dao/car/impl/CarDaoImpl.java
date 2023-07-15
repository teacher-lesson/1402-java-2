package org.example.dao.car.impl;

import org.example.dao.BaseDaoImpl;
import org.example.dao.HibernateHelper;
import org.example.dao.car.CarDao;
import org.example.domain.car.Car;

public class CarDaoImpl extends BaseDaoImpl<Car, Integer> implements CarDao {

    private final HibernateHelper helper;

    public CarDaoImpl(HibernateHelper helper) {
        this.helper = helper;
    }

    @Override
    protected HibernateHelper getHelper() {
        return helper;
    }

    @Override
    protected Class<Car> getEntityClass() {
        return Car.class;
    }
}
