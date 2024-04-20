package com.example.springsecurity686.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.springsecurity686.entity.LoginUser;
import com.example.springsecurity686.entity.User;
import com.example.springsecurity686.mapper.MenuMapper;
import com.example.springsecurity686.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author SR
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(wrapper);
        System.out.println("UserDetailsServiceImpl++++++++++++++++loadUserByUsername" + user.toString());
        //如果查询不到数据就通过抛出异常来给出提示
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或密码错误");
        }
        //TODO 根据用户查询权限信息 添加到LoginUser中

        //封装成UserDetails对象返回
        List<String> permissionKeyList = menuMapper.selectPermsByUserId(user.getId());
        System.out.println("11111111111111111111111111111111111111111111111111111111111111111");
        System.out.println(permissionKeyList);
//        List<String> list = new ArrayList<>(Arrays.asList("test"));
        return new LoginUser(user, permissionKeyList);
    }
}