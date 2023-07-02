package com.dhurata.firstApp.ProductManager.controller;

import com.dhurata.firstApp.ProductManager.model.User;
import com.dhurata.firstApp.ProductManager.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostConstruct
    public void initRolesAndUser(){
        userService.initRolesAndUser();
    }
    @PostMapping("/registerNewUser")
    public User registerNewUser (@RequestBody  User user){
       return userService.registerNewUser(user);
    }
    @GetMapping("/adminZone")
    @PreAuthorize("hasRole('Admin')")
    public String adminZone(){
        return "Welcome Admin";
    }
    @GetMapping("/userZone")
    @PreAuthorize("hasRole('User')")
    public String userZone(){
        return "Welcome User";
    }
}
