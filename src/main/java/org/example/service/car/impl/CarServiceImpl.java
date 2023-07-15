package org.example.service.car.impl;

import org.example.dao.car.CarDao;
import org.example.domain.car.Car;
import org.example.service.BaseServiceImpl;
import org.example.service.car.CarService;
import org.example.service.input.TerminalInput;
import org.example.service.person.PersonService;
import org.example.view.car.CarView;

public class CarServiceImpl extends BaseServiceImpl<Car, Integer> implements CarService {

    private final CarDao carDao;
    private final PersonService personService;
    private final TerminalInput input;

    public CarServiceImpl(CarDao carDao, PersonService personService, TerminalInput input) {
        this.carDao = carDao;
        this.personService = personService;
        this.input = input;
    }

    @Override
    protected CarDao getDao() {
        return this.carDao;
    }

    @Override
    public void addCar() {
        CarView.showName();
        final String carName = input.readLine();

        CarView.showModol();
        final String modol = input.readLine();

        CarView.showYear();
        final int year = input.readInt();

        CarView.showOwner(personService.read());
        final int ownerId = input.readInt();

        final Car car = new Car(carName, modol, year, personService.read(ownerId));
        this.create(car);
    }
}
