package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/main")
    public String showMainPage() {
        System.out.println("Test");
        return "home/main";
    }
}
