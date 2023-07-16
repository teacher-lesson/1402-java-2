package com.example.controller.user;

import com.example.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/") //FIXME
    public String addNewUser(Model model) {
        model.addAttribute("data", userService.readAllWithoutBook());
        return "user/add";
    }

    @GetMapping("/list")
    public String showAllUser(Model model) {
        model.addAttribute("data", userService.readAllWithoutBook());
        return "user/list";
    }
}
