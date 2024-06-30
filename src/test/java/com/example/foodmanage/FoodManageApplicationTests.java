package com.example.foodmanage;

import com.example.foodmanage.Entity.BusinessMessage;
import com.example.foodmanage.Mapper.BusinessMapper;
import com.example.foodmanage.Mapper.OrdersMapper;
import com.example.foodmanage.Service.BusinessService;
import com.example.foodmanage.Service.IntegralService;
import com.example.foodmanage.Service.OrderService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootTest
class FoodManageApplicationTests {
    @Resource
    OrderService service;
    @Test
    void contextLoads() {
        System.out.println(service.UpdateDeliverDate("2023-10-22 21:25:04",3));
    }

}
