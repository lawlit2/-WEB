package com.example.foodmanage.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface OrdersMapper {
    @Insert("update orders set FollowUpProductTime = #{time} where id = #{id}")
    Integer UpdateProductTime(String time,int id);
    @Delete("update orders set FollowUpProductTime = NULL where id = #{id}")
    Integer DeleteProductTime(int id);
    @Select("select  FollowUpProductTime from orders where id = #{id}")
    String SelectTimeById(int id);
}
