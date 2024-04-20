package com.example.springsecurity686.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecurity686.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
