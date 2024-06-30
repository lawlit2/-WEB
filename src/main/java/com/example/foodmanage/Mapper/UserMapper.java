package com.example.foodmanage.Mapper;

import com.example.foodmanage.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User SelectUserById(int id);
}
