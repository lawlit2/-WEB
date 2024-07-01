package com.example.foodmanage.Controller;

import com.alibaba.fastjson2.JSON;
import com.example.foodmanage.Service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Resource
    UserService service;
    @PostMapping("/User/login")
    public String login(@RequestParam("phone") String phone,
                        @RequestParam("password") String password){
        Map<String ,Object> map = new HashMap<>();
        if (service.JudgementUser(phone,password)) {
            map.put("message","登录成功");
            map.put("success",true);
        }else{
            map.put("message","登录失败");
            map.put("success",false);
        }
        return JSON.toJSONString(map);
    }
}
