package com.example.foodmanage.Controller;

import com.alibaba.fastjson2.JSON;
import com.example.foodmanage.Entity.BusinessMessage;
import com.example.foodmanage.Service.BusinessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@Tag(name = "{Business表相关接口}")
@RestController
public class BusinessMessageController {
    @Resource
    BusinessService service;
    @Operation(summary = "根据商家地址返回商家")
    @PostMapping("/BusinessMessage/SelectMessage")
    public BusinessMessage SelectMessage(@Parameter(description = "地址") @RequestParam("address") String address){
        return service.SelectBusinessByAddress(address);
    }
    @Operation(summary = "查询一周内可配送日期")
    @PostMapping("/BusinessMessage/SelectWeeklyDeliveryTime")
    public String SelectWeeklyDeliveryTime(@RequestParam("id") int id){
        Map<String,Object> result = new HashMap<>();
        String s = service.SelectDeliveryTime(id);
        result.put("一周内可配送日期",s);
        return JSON.toJSONString(result);
    }
    @Operation(summary = "把\"一周内可配送日期\" 字段重置未NULL")
    @PostMapping("/BusinessMessage/DeleteWeeklyDeliveryTime")
    public String DeleteWeeklyDeliveryTime(@RequestParam("id")int id){
        Map<String ,Object> result = new HashMap<>();
        if (service.DeleteDeliveryTime(id)) {
            result.put("message","一周内可配送日期删除成功");
            result.put("success",true);
        }else{
            result.put("message","一周内可配送日期删除失败");
            result.put("success",false);
        }
        return JSON.toJSONString(result);
    }
    @Operation(summary = "更新或添加一周内可配送日期")
    @PostMapping("/BusinessMessage/UpdateWeeklyDeliveryTime")
    public String UpdateWeeklyDeliveryTime(@RequestParam("id")int id,
                                           @Parameter(description = "String类型日期")@RequestParam("WeeklyDeliveryTime") String time){
        Map<String ,Object> result = new HashMap<>();
        if (service.UpdateDeliveryTime(time, id)) {
            result.put("message","一周内可配送日期添加成功");
            result.put("success",true);
        }else{
            result.put("message","一周内可配送日期添加失败");
            result.put("success",false);
        }
        return JSON.toJSONString(result);
    }
    @Operation(summary = "查询可以配送时间段")
    @PostMapping("/BusinessMessage/SelectDeliveryTimeWindow")
    public String SelectDeliveryTimeWindow(@RequestParam("id") int id){
        String s = service.SelectTimeWindow(id);
        Map<String , Object> result = new HashMap<>();
        result.put("可以配送时间段",s);
        return JSON.toJSONString(result);
    }
    @Operation(summary = "删除可配送时间段的值(NULL)")
    @PostMapping("/BusinessMessage/DeleteDeliveryTimeWindow")
    public String DeleteDeliveryTimeWindow(@RequestParam("id") int id){
        Map<String ,Object> result = new HashMap<>();
        if (service.DeleteTimeWindow(id)) {
            result.put("message","可配送时间段信息删除成功");
            result.put("success",true);
        }else {
            result.put("message","可配送时间段信息删除失败");
            result.put("success",false);
        }
        return JSON.toJSONString(result);
    }
    @Operation(summary = "更新/添加可配送时间段")
    @PostMapping("/BusinessMessage/UpdateDeliveryTimeWindow")
    public String UpdateDeliveryTimeWindow(@RequestParam("id")int id,
                                           @Parameter(description = "时间段值")@RequestParam("deliveryTimeWindow") String window){
        Map<String ,Object> result = new HashMap<>();
        if (service.UpdateTimeWindow(window, id)) {
            result.put("message","可配送时间段信息添加成功");
            result.put("success",true);
        }else{
            result.put("message","可配送时间段信息添加失败");
            result.put("success",false);
        }
        return JSON.toJSONString(result);
    }
}
