package org.example;

import org.example.config.SpringConfig;
import org.example.ioc.BaseballCouch;
import org.example.ioc.BasketBallCouch;
import org.example.ioc.Couch;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        ApplicationContext ctx =
//                new ClassPathXmlApplicationContext("application-context.xml");

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        Couch couch = ctx.getBean("couch", Couch.class);

        couch.getDailyWork();

        couch.callFortuneService();

        System.out.println(couch);
    }
}
