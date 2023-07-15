package org.example.service.person.impl;

import org.example.dao.person.PersonDao;
import org.example.domain.person.Person;
import org.example.service.BaseServiceImpl;
import org.example.service.input.TerminalInput;
import org.example.service.person.PersonService;
import org.example.view.person.PersonView;

public class PersonServiceImpl extends BaseServiceImpl<Person, Integer> implements PersonService {

    private final PersonDao carDao;
    private final TerminalInput input;

    public PersonServiceImpl(PersonDao carDao, TerminalInput input) {
        this.carDao = carDao;
        this.input = input;
    }

    @Override
    protected PersonDao getDao() {
        return this.carDao;
    }

    @Override
    public void addPerson() {
        PersonView.showFirstName();
        final String firstName = input.readLine();
        PersonView.showLastName();
        final String lastName = input.readLine();

        create(new Person(firstName, lastName));
    }

    @Override
    public void showAllPerson() {
        // TODO
    }
}
