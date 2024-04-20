package com.example.springsecurity686;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.example.springsecurity686.mapper")
public class SpringBootDemoApplication {

    public static void main(String[] args) {

        //返回值是一个spring容器
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootDemoApplication.class, args);
        // redisTemplate是否由spring管理
        Object bean = run.getBean("redisTemplate");
        System.out.println(bean);
        //容器中管理的bean的数量
        int defindBeanCount = run.getBeanDefinitionCount();
        System.out.println(defindBeanCount);
    }
}
