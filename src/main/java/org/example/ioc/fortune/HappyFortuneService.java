package org.example.ioc.fortune;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "This is happy fortune service!";
    }
}
