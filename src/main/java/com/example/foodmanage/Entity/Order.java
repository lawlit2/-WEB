package com.example.foodmanage.Entity;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Order {
    int id;
    String order_no;
    String time;
    String pay_time;
    String status;
    int business_id;
    String user;
    String phone;
    String address;
    int user_id;
    BigDecimal discount;
    BigDecimal actual;
    String comment;
    String cover;
    String name;
    String FollowUpProductTime;
    String deliveryDate;
    String merchantPhone;
    String deliveryPhone;
    String estimateDeliveryTime;
}
