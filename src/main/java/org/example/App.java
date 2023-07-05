package org.example;

import org.example.player.Player;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        //spring container (Application context) in XML way
//        var context =
//                new ClassPathXmlApplicationContext("application-context.xml");

        //spring container (Application context) in Annotaion way
        var context =
                new AnnotationConfigApplicationContext(Config.class);

        Player player = context.getBean(Player.class);

        System.out.println(player);
    }
}
