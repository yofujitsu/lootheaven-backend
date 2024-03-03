package com.example.lootheaven.controllers;

import com.example.lootheaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;
    @GetMapping("/")
    public String showProfile(RequestParam userId) {
        return "lol";
    }
}
