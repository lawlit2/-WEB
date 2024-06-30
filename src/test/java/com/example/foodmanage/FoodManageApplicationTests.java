package com.example.foodmanage;

import com.example.foodmanage.Entity.BusinessMessage;
import com.example.foodmanage.Mapper.BusinessMapper;
import com.example.foodmanage.Service.BusinessService;
import com.example.foodmanage.Service.IntegralService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootTest
class FoodManageApplicationTests {
    @Resource
    BusinessMapper service;
    @Test
    void contextLoads() {
        System.out.println("sss");
       BusinessMessage businessMessage = service.SelectBusinessByAddress("合肥市望江路110号");
       System.out.println(businessMessage);
    }

}
