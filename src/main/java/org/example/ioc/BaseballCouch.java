package org.example.ioc;

import org.example.ioc.fortune.FortuneService;

public class BaseballCouch implements Couch {


    private FortuneService fortuneService;

    public BaseballCouch(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }


    @Override
    public void getDailyWork() {
        System.out.println("Play base ball!");
    }

    @Override
    public void callFortuneService() {
        System.out.println(fortuneService.getFortune());
    }
}
