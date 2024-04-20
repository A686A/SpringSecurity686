package com.example.springsecurity686.service;

import com.example.springsecurity686.entity.ResponseResult;
import com.example.springsecurity686.entity.User;

public interface LoginServcie {

    ResponseResult login(User user);

    ResponseResult logout();

}
