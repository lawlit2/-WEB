package com.example.foodmanage.Mapper;

import com.example.foodmanage.Entity.Good;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("Select * from goods where dailySetMeal = 1")
    List<Good> SelectDailySetMeal();
    @Update("update goods set dailySetMeal = 1 where id = #{id}")
    Integer UpdateDailySetMeal(int id);
    @Delete("update goods set dailySetMeal = 0 where id = #{id}")
    Integer DeleteDailySetMeal(int id);
    @Select("select Dollar from goods where id = #{id} ")
    BigDecimal SelectDollar(int id);
    @Update("update goods set Dollar = #{dollar} where id = #{id}")
    Integer UpdateDollar(BigDecimal dollar,int id);
    @Delete("update Dollar set Dollar = 0.00 where id = #{id}")
    Integer DeleteDollar(int id);
}
