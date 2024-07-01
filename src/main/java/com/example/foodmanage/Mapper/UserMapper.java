package com.example.foodmanage.Mapper;

import com.example.foodmanage.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where phone = #{phone} And password = #{password}")
    User SelectUserById(String phone, String password);
}
