package com.example.springsecurity686;

import com.example.springsecurity686.mapper.MenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class LoginTest {

    @Autowired
    MenuMapper mapper;

    @Test
    void testPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("1234");
        System.out.println(password);
        System.out.println(
                bCryptPasswordEncoder.matches(
                        "1234", "$2a$10$icWy4/UNf5Ttz/dEyTAkWuWwWjMYwk2wN7DWSsRVMz3WsJZOjlAT."));

    }

    @Test
    public void testRole() {

        List<String> list = mapper.selectPermsByUserId(1L);

    }
}
