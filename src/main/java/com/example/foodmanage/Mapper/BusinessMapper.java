package com.example.foodmanage.Mapper;

import com.example.foodmanage.Entity.BusinessMessage;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BusinessMapper {
    @Select("Select * from business where address = #{address}")
    BusinessMessage SelectBusinessByAddress(String address);
    @Update("Update business set weeklyDeliveryTime = #{DeliveryTime} where id = #{id}")
    Integer UpdateDeliveryTime(String DeliveryTime,int id);
    @Delete("Update business set weeklyDeliveryTime = NULL where id = #{id}")
    Integer DeleteDeliveryTime(int id);
    @Select("Select weeklyDeliveryTime from business where id = #{id}")
    String SelectDeliveryTime(int id);

    @Update("Update business set deliveryTimeWindow = #{TimeWindow} where id = #{id}")
    Integer UpdateTimeWindow(String TimeWindow,int id);
    @Delete("Update business set deliveryTimeWindow = NULL where id = #{id}")
    Integer DeleteTimeWindow(int id);
    @Select("Select deliveryTimeWindow from business where id = #{id}")
    String SelectTimeWindow(int id);
}
