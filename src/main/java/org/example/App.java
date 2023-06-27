package org.example;

import org.example.ioc.BaseballCouch;
import org.example.ioc.BasketBallCouch;
import org.example.ioc.Couch;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("application-context.xml");

        Couch couch = ctx.getBean("couch2", Couch.class);

        couch.getDailyWork();

        couch.callFortuneService();

        System.out.println(couch);

        ctx.close();
    }
}
