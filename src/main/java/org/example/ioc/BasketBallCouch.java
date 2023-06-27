package org.example.ioc;

import org.example.ioc.fortune.FortuneService;

public class BasketBallCouch implements Couch {

    private FortuneService fortuneService;

    public BasketBallCouch(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public void getDailyWork() {
        System.out.println("This play basketball!");
    }

    @Override
    public void callFortuneService() {
        System.out.println(fortuneService.getFortune());
    }
}
