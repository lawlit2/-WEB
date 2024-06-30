package com.example.foodmanage.Controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.foodmanage.Entity.BusinessMessage;
import com.example.foodmanage.Service.BusinessService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessMessageController {
    @Resource
    BusinessService service;
    @PostMapping("/BusinessMessage/SelectMessage")
    public BusinessMessage SelectMessage(@RequestParam("address") String address){
        BusinessMessage message = service.SelectBusinessByAddress(address);
        return message;
    }

}
