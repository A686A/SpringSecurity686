package com.example.springsecurity686.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class s01Controller {

    // http://localhost:8084/user/hello
    @GetMapping("/user/hello")
    @PreAuthorize("hasAuthority('system:dept:list2')")
    public String security() {

        // 获取当前登录用户名
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = null;
        if (authentication != null && authentication.isAuthenticated()) {
            username = authentication.getName(); // 获取用户名
        }
        System.out.println(username);
        return username;
    }
}
