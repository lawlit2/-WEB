package com.example.foodmanage.Controller;

import com.alibaba.fastjson2.JSON;
import com.example.foodmanage.Service.IntegralService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//积分接口
@RestController
public class IntegralController {
    @Resource
    IntegralService service;
    @PostMapping("/Integral/add")
    public String  AddIntegral(@RequestParam("id") int  id,
                             @RequestParam("integral") int integral){
        Map<String, Object> result = new HashMap<>();
        if(service.AddIntegralById(id,integral)){
            result.put("message","积分修改/添加成功");
            result.put("success",true);
        }else{
            result.put("message","积分修改/添加失败");
            result.put("success",false);
        }
        return JSON.toJSONString(result);
    }
    @PostMapping("/Integral/delete")
    public String DeleteIntegral(@RequestParam("id") int id){
        Map<String, Object> result = new HashMap<>();
        if(service.DeleteIntegralById(id)){
            result.put("message","积分删除成功");
            result.put("success",true);
        }else{
            result.put("message","积分删除失败");
            result.put("success",false);
        }
        return JSON.toJSONString(result);
    }
    @PostMapping("/Integral/Select")
    public String SelectIntegral(@RequestParam("id") int id){
        Map<String, Object> result = new HashMap<>();
        result.put("Integral",service.SelectIntegralById(id));
        return JSON.toJSONString(result);
    }
}
