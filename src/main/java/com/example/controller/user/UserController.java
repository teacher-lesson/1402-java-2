package com.example.controller.user;


import com.example.model.User;
import com.example.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/add")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-add";
    }

    @PostMapping
    public String addUser(@ModelAttribute User user) {
        userService.create(user);
        return "user-added";
    }

    @GetMapping("/")
    public String showAllUserForm(Model model) {
        model.addAttribute("list", userService.readAll().collect(Collectors.toSet()));
        return "user-list";
    }
}
