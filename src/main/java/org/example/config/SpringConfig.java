package org.example.config;

import org.example.ioc.Couch;
import org.example.ioc.FootballCouch;
import org.example.ioc.fortune.FortuneService;
import org.example.ioc.fortune.HappyFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:props.properties")
public class SpringConfig {

    @Bean
    public Couch couch2(FortuneService fortuneService) {
        final FootballCouch footballCouch = new FootballCouch();
        footballCouch.setName("Footbale player");
        footballCouch.setFortuneService(fortuneService);

        return footballCouch;
    }
}
