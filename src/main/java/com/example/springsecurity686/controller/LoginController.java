package com.example.springsecurity686.controller;

import com.example.springsecurity686.entity.ResponseResult;
import com.example.springsecurity686.entity.User;
import com.example.springsecurity686.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginServcie loginServcie;

    //http://localhost:8084/user/login
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        return loginServcie.login(user);
    }

    //http://localhost:8084/user/logout
    @GetMapping("/user/logout")
    public ResponseResult logout() {
        return loginServcie.logout();
    }
}