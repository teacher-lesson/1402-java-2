package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {




    @RequestMapping("/register")
    public String registerForm() {
        return "user/register-form";
    }


    @RequestMapping("/user/register")
    public String register(HttpServletRequest request, Model model) {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final String repeatPassword = request.getParameter("repeatPassword");

        final HttpSession session = request.getSession();



        System.out.println(username);
        System.out.println(password);
        System.out.println(repeatPassword);

        model.addAttribute("showName", username);

        return "user/registered";
    }
}
