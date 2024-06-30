package com.example.foodmanage.Entity;

import lombok.Data;

@Data
public class OrderInfo {
    private String merchantPhone;
    private String deliveryPhone;
    private String estimatedDeliveryTime;

}
