package com.example.foodmanage.Controller;

import com.alibaba.fastjson2.JSON;
import com.example.foodmanage.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@Tag(name = "{User}登录相关接口")
@RestController
public class UserController {
    @Resource
    UserService service;
    @Operation(summary = "登录相关接口")
    @PostMapping("/User/login")
    public String login(@Parameter(description = "电话") @RequestParam("phone") String phone,
                        @Parameter(description = "密码")@RequestParam("password") String password){
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
