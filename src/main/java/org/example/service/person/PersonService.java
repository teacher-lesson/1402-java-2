package org.example.service.person;

import org.example.domain.person.Person;
import org.example.service.BaseService;

public interface PersonService extends BaseService<Person, Integer> {


    void addPerson();

    void showAllPerson();
}
