package org.example;

import org.example.player.Player;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        var context =
                new ClassPathXmlApplicationContext("application-context.xml");

        Player player = context.getBean("player", Player.class);

        System.out.println(player);
    }
}
