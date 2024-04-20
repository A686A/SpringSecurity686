package com.example.springsecurity686.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecurity686.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/**
 * @Author SR
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(@Param("userid") Long userid);
}
