package org.example.ioc.fortune;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Value("${fortune-service.name.my}")
    private String name;
    @Override
    public String getFortune() {
        return "This is happy fortune service!";
    }
}
