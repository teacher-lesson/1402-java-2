package org.example;

public class Person {
    private String name;
    private int age;
    private boolean alive;


    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public boolean isAlive() {
        return alive;
    }

    public Person setAlive(boolean alive) {
        this.alive = alive;
        return this;
    }
}
