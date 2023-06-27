package org.example.ioc;

import org.example.ioc.fortune.FortuneService;

public class FootballCouch implements Couch {

    private String name;
    private FortuneService fortuneService;

    @Override
    public void getDailyWork() {
        System.out.println("Play football!");
    }

    @Override
    public void callFortuneService() {
        System.out.println(fortuneService.getFortune());
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FootballCouch{" +
                "name='" + name + '\'' +
                ", fortuneService=" + fortuneService +
                '}';
    }
}
