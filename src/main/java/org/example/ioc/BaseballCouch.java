package org.example.ioc;

import org.example.ioc.fortune.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("couch")
public class BaseballCouch implements Couch {
    @Autowired
    private FortuneService fortuneService;

    @Override
    public void getDailyWork() {
        System.out.println("Play base ball!");
    }

    @Override
    public void callFortuneService() {
        System.out.println(fortuneService.getFortune());
    }
}
