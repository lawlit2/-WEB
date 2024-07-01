package com.example.foodmanage;

import com.example.foodmanage.Entity.BusinessMessage;
import com.example.foodmanage.Entity.User;
import com.example.foodmanage.Mapper.BusinessMapper;
import com.example.foodmanage.Mapper.OrdersMapper;
import com.example.foodmanage.Mapper.UserMapper;
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
    UserMapper mapper;
    @Test
    void contextLoads() {
        User user = mapper.SelectUserById("13899887766", "123");
        System.out.println(user.toString());
    }

}
