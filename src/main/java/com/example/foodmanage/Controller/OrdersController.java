package com.example.foodmanage.Controller;

import com.alibaba.fastjson2.JSON;
import com.example.foodmanage.Service.BusinessService;
import com.example.foodmanage.Service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrdersController {
    @Resource
    OrderService service;
    @PostMapping("/Orders/AddTime")
    public String AddProductTime(@RequestParam("FollowUpProductTime") String time,
                                 @RequestParam("id") int id){
        Map<String, Object> result = new HashMap<>();
        if(service.AddProductTimeById(time,id)){
            result.put("message", "下次配送时间添加成功");
            result.put("success", true);
        } else  {
            result.put("message", "下次配送时间添加失败");
            result.put("success", false);
        }
        return JSON.toJSONString(result);
    }
    @PostMapping("/Orders/SelectTime")
    public String SelectProductTime(@RequestParam("id") int id){
        String s = service.SelectProductTimeById(id);
        Map<String, Object> result = new HashMap<>();
        result.put("下次配送时间",s);
        return JSON.toJSONString(result);
    }
    @PostMapping("/Orders/DeleteTime")
    public String DeleteProductTime(@RequestParam("id") int id){
        Map<String, Object> result = new HashMap<>();
        if (service.DeleteProductTimeById(id)) {
            result.put("message", "下次配送时间删除成功");
            result.put("success", true);
        }else {
            result.put("message", "下次配送时间删除失败");
            result.put("success", false);
        }
        return JSON.toJSONString(result);
    }
}
