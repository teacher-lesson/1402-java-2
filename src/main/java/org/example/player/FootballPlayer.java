package org.example.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.couch.Couch;


@Data
public class FootballPlayer implements Player {
    private String name;
    private int age;
    private Couch couch;

    public FootballPlayer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public FootballPlayer setCustomCouch(Couch couch) {
        this.couch = couch;
        return this;
    }
}
