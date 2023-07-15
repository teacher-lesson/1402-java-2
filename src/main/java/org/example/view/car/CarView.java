package org.example.view.car;

import org.example.domain.person.Person;

import java.util.List;

public class CarView {


    public static void showName() {
        System.out.println("Input name of car:");
    }

    public static void showModol() {
        System.out.println("Input modol of car:");
    }

    public static void showYear() {
        System.out.println("Input year of car:");
    }

    public static void showOwner(List<Person> owners) {
        System.out.println("Choise owner car :");
        owners.forEach(System.out::println);

//        for (Person person : owners) {
//            System.out.println(person);
//        }

    }
}
