package com.example.foodmanage.Mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface IntegralMapper {
    @Select("select integral from user where id = #{id}")
    Integer SelectIntegralById(int id);
    @Update("update user set integral = #{integral} where id = #{id}")
    int UpdateIntegralById(@Param("id") int id ,@Param("integral") int integral);
    @Delete("update user set integral = NULL where id = #{id}")
    int DeleteIntegralById(int id);

}
