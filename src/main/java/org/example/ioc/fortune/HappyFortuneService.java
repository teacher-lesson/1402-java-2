package org.example.ioc.fortune;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "This is happy fortune service!";
    }
}
