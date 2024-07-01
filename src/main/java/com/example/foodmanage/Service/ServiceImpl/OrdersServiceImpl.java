package com.example.foodmanage.Service.ServiceImpl;


import com.example.foodmanage.Entity.Order;
import com.example.foodmanage.Entity.OrderInfo;
import com.example.foodmanage.Mapper.OrdersMapper;
import com.example.foodmanage.Service.OrderService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrderService {
    @Resource
    OrdersMapper mapper;
    @Override
    public boolean AddProductTimeById(String time, int id) {
        Integer integer = mapper.UpdateProductTime(time, id);
        return integer != null;
    }

    @Override
    public String SelectProductTimeById(int id) {

        try{
            return mapper.SelectTimeById(id);
        }catch (NullPointerException e){
            return "null";
        }

    }

    @Override
    public boolean DeleteProductTimeById(int id) {
        Integer integer = mapper.DeleteProductTime(id);
        return integer != null;
    }

    @Override
    public String SelectDeliverDate(int id) {
       return  mapper.SelectDeliverDate(id);
    }

    @Override
    public boolean UpdateDeliverDate(String date, int id) {

            Integer integer = mapper.UpdateDeliverDate(date, id);
            return integer != null;

    }

    @Override
    public boolean DeleteDeliverDate(int id) {
        Integer integer = mapper.DeleteDeliverDate(id);
        return integer != null;
    }

    @Override
    public OrderInfo selectOrderInfo(int id) {
        OrderInfo orderInfo = mapper.selectOrderInfo(id);
        return orderInfo;
    }

    @Override
    public boolean updateOrderInfo(OrderInfo orderInfo, int id) {
        Integer i = mapper.updateOrderInfo(orderInfo, id);
        return i!=null;

    }

    @Override
    public boolean DeleteOrderInfo(int id) {
        Integer integer = mapper.DeleteOrderInfo(id);
        return integer!=null;
    }

    @Override
    public List<Order> SelectOrdersByBusinessID(int business_id) {
        List<Order> orders = mapper.SelectOrderByBusinessID(business_id);
        return orders;
    }
}
