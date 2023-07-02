package com.example.service;

import com.example.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonService {

    private List<Person> people = new ArrayList<>();

    {
        people.add(new Person("Ali", "Alavi", 20));
        people.add(new Person("Hassan", "Alavi", 21));
        people.add(new Person("Hossein", "Alavi", 22));
    }

    public List<Person> listPerson() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }
}
