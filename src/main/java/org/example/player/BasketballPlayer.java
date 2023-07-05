package org.example.player;

import lombok.Data;
import org.example.couch.Couch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Data

@Component
@Scope("singleton")
public class BasketballPlayer implements Player {
    private String name;
    private int age;

    @Autowired
    @Qualifier("basketballCouch")
    private Couch couch;

//    @Autowired
//    public BasketballPlayer(
//            @Qualifier("basketballCouch")
//            Couch couch
//    ) {
//        this.couch = couch;
//    }
}
