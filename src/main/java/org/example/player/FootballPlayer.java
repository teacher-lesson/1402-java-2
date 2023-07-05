package org.example.player;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.couch.Couch;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.time.Period;
import java.util.Calendar;
import java.util.Date;


@Data
public class FootballPlayer implements Player {
    private String name;
    private Date birthDay;

    private Couch couch;
    private int age;

    public FootballPlayer(String name, Date birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public FootballPlayer setCustomCouch(Couch couch) {
        this.couch = couch;
        return this;
    }

    @PostConstruct
    public void calculateAge() {

        var now = Calendar.getInstance();
        var date = Calendar.getInstance();
        date.setTimeInMillis(birthDay.getTime());

        age = now.get(Calendar.YEAR) - date.get(Calendar.YEAR);
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        var now = Calendar.getInstance();
        var date = Calendar.getInstance();
        date.setTimeInMillis(birthDay.getTime());

        age = now.get(Calendar.YEAR) - date.get(Calendar.YEAR);
    }

    @Override
    public void destroy() throws Exception {
    }
}
