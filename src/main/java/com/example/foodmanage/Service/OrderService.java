package com.example.foodmanage.Service;

import com.example.foodmanage.Entity.Order;
import com.example.foodmanage.Entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
    boolean AddProductTimeById(String time,int id);
    String SelectProductTimeById(int id);
    boolean DeleteProductTimeById(int id);
    String SelectDeliverDate(int id);
    boolean UpdateDeliverDate(String date,int id);
    boolean DeleteDeliverDate(int id);
    OrderInfo selectOrderInfo( int id);
    boolean  updateOrderInfo( OrderInfo orderInfo,  int id);
    boolean  DeleteOrderInfo(int id);
    List<Order> SelectOrdersByBusinessID(int business_id);
}
