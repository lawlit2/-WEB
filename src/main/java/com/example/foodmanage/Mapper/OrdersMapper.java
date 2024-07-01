package com.example.foodmanage.Mapper;

import com.example.foodmanage.Entity.Order;
import com.example.foodmanage.Entity.OrderInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrdersMapper {
    @Update("update orders set FollowUpProductTime = #{time} where id = #{id}")
    Integer UpdateProductTime(String time,int id);
    @Update("update orders set FollowUpProductTime = NULL where id = #{id}")
    Integer DeleteProductTime(int id);
    @Select("select  FollowUpProductTime from orders where id = #{id}")
    String SelectTimeById(int id);
    @Select("Select deliveryDate from orders where id = #{id}")
    String SelectDeliverDate(int id);
    @Update("update orders set deliveryDate = #{date} where id = #{id}")
    Integer UpdateDeliverDate(@Param("date") String date,@Param("id") int id);
    @Update("update orders set deliveryDate = NULL where id = #{id}")
    Integer DeleteDeliverDate(int id);
    @Select("SELECT merchantPhone, deliveryPhone, estimatedDeliveryTime FROM orders WHERE id = #{id}")
    OrderInfo selectOrderInfo(@Param("id") int id);
    @Update("UPDATE orders SET merchantPhone = #{orderInfo.merchantPhone}, deliveryPhone = #{orderInfo.deliveryPhone}, estimatedDeliveryTime = #{orderInfo.estimatedDeliveryTime} WHERE id = #{id}")
    Integer updateOrderInfo(@Param("orderInfo") OrderInfo orderInfo, @Param("id") int id);
    @Update("UPDATE orders SET merchantPhone =NULL, deliveryPhone =NULL, estimatedDeliveryTime = NULL WHERE id = #{id}")
    Integer DeleteOrderInfo(@Param("id") int id);
    @Select("Select * from orders where business_id = #{business_id}")
    List<Order> SelectOrderByBusinessID(int business_id);
}
