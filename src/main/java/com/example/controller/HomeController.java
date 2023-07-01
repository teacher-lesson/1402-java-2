package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(HttpServletRequest request, Model model) {
        final HttpSession session = request.getSession();

        final String username = (String) session.getAttribute("username");

        if (username != null) { // mean user has login
            model.addAttribute("username", username)
            return "home/logined-home";
        } else {
            return "home/guess-home";
        }

    }

}
