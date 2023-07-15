package org.example;

import org.example.dao.HibernateHelper;
import org.example.dao.car.CarDao;
import org.example.dao.car.impl.CarDaoImpl;
import org.example.dao.person.PersonDao;
import org.example.dao.person.impl.PersonDaoImpl;
import org.example.service.car.CarService;
import org.example.service.car.impl.CarServiceImpl;
import org.example.service.input.TerminalInput;
import org.example.service.input.impl.TerminalInputImpl;
import org.example.service.person.PersonService;
import org.example.service.person.impl.PersonServiceImpl;
import org.example.view.MainView;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        final var helper = new HibernateHelper();
        final CarDao carDao = new CarDaoImpl(helper);
        final PersonDao personDao = new PersonDaoImpl(helper);
        final TerminalInput input = new TerminalInputImpl(new Scanner(System.in));

        final PersonService personService = new PersonServiceImpl(personDao, input);
        final CarService carService = new CarServiceImpl(carDao,personService, input);


        showMenu(input, personService, carService);

    }

    private static void showMenu(TerminalInput input, PersonService personService, CarService carService) {
        while (true) {
            MainView.showMenu();
            switch (input.readLine()) {
                case "1" -> personService.addPerson();
                case "2" -> carService.addCar();
                case "3" -> personService.showAllPerson();
                case "e" -> {
                    return;
                }
                default -> MainView.showMistake();
            }

        }
    }
}
