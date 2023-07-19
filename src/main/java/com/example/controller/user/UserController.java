package com.example.controller.user;

import com.example.domain.user.User;
import com.example.service.user.UserMapper;
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
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @PostMapping("/") //FIXME
    public String addNewUser(Model model) {
        model.addAttribute("data", userService.readAll());
        return "user/add";
    }

    @GetMapping("/list")
    public String showAllUser(Model model) {
        model.addAttribute("data", userService.readAll());
        return "user/list";
    }

    @GetMapping(value = "/test")
    public String test() {
        userService.create(userMapper.toDto(
                new User("admin1", "pass1", "Ali1", "Alavi1", 21)
        ));
        userService.create(userMapper.toDto(
                new User("admin2", "pass2", "Ali2", "Alavi2", 22)
        ));
        userService.create(userMapper.toDto(
                new User("admin3", "pass3", "Ali3", "Alavi3", 23)
        ));
        userService.create(userMapper.toDto(
                new User("admin4", "pass4", "Ali4", "Alavi4", 24)
        ));
        userService.create(userMapper.toDto(
                new User("admin5", "pass5", "Ali5", "Alavi5", 25)
        ));

        return "OK";
    }
}
