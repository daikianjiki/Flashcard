package com.revature.SpringBootRefresher.controllers;

import com.revature.SpringBootRefresher.models.User;
import com.revature.SpringBootRefresher.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("login")
    public User loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }
}
