package com.example.foodmanage.Mapper;

import com.example.foodmanage.Entity.BusinessMessage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BusinessMapper {
    @Select("Select * from business where address = #{address}")
    BusinessMessage SelectBusinessByAddress(String address);

}
