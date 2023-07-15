package org.example.service.car;

import org.example.domain.car.Car;
import org.example.service.BaseService;

public interface CarService extends BaseService<Car, Integer> {


    void addCar();
}
