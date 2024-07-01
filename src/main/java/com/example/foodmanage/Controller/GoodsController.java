package com.example.foodmanage.Controller;

import com.alibaba.fastjson2.JSON;
import com.example.foodmanage.Entity.Good;
import com.example.foodmanage.Service.GoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Tag(name = "{goods表相关接口}")
@RestController
public class GoodsController {
    @Resource
    GoodService service;
    @Operation(summary = "查询每日套餐")
    @PostMapping("/Goods/SelectDailySetMeal")
    public String SelectDailySetMeal(){
        List<Good> goods = service.SelectDailySetMeal();
        return JSON.toJSONString(goods);
    }
    @Operation(summary = "更新添加每日套餐")
    @PostMapping("/Goods/UpdateDailySetMeal")
    public String UpdateDailySetMeal(@RequestParam("id") int id){
        Map<String ,Object> map = new HashMap<>();
        if (service.UpdateDailySetMeal(id)) {
            map.put("message","每日优惠添加成功");
            map.put("success",true);
        }else{
            map.put("message","每日优惠添加失败");
            map.put("success",false);
        }
        return JSON.toJSONString(map);
    }
    @Operation(summary = "删除每日套餐字段值")
    @PostMapping("/Goods/DeleteDailySetMeal")
    public String DeleteDailySetMeal(@RequestParam("id")int id){
        Map<String ,Object> map = new HashMap<>();
        if (service.DeleteDailySetMeal(id)) {
            map.put("message","每日优惠删除成功");
            map.put("success",true);
        }else{
            map.put("message","每日优惠删除失败");
            map.put("success",false);
        }
        return JSON.toJSONString(map);
    }
    @Operation(summary = "查找美元")
    @PostMapping("/Goods/SelectDollar")
    public String SelectDollar(@RequestParam("id")int id){
        Map<String ,Object> map = new HashMap<>();
        map .put("dollar",service.SelectDollar(id));
        return JSON.toJSONString(map);
    }
    @Operation(summary = "更新/添加美元")
    @PostMapping("/Goods/UpdateDollar")
    public String UpdateDollar(@RequestParam("id")int id,
                               @Parameter(description = "美元值") @RequestParam("Dollar")BigDecimal dollar){
        Map<String ,Object> map = new HashMap<>();
        if (service.UpdateDollar(dollar, id)) {
            map.put("message","美元添加成功");
            map.put("success",true);
        }else{
            map.put("message","美元添加失败");
            map.put("success",false);
        }
        return JSON.toJSONString(map);
    }
    @Operation(summary = "删除美元对应的值")
    @PostMapping("/Goods/DeleteDollar")
    public  String DeleteDollar(@RequestParam("id")int id){
        Map<String ,Object> map = new HashMap<>();
        if (service.DeleteDollar(id) ) {
            map.put("message","美元删除成功");
            map.put("success",true);
        }else{
            map.put("message","美元删除失败");
            map.put("success",false);
        }
        return JSON.toJSONString(map);
    }
    @Operation(summary = "查询优惠活动的商品相关信息")
    @PostMapping("/Goods/SelectGoodSpecialOffers")
    public String SelectSpecialOffers() {
        List<Good> goods = service.SelectOrderBySpecialOffers();
        if (goods == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "未找到优惠活动相关信息");
            return JSON.toJSONString(map);
        } else {
            return JSON.toJSONString(goods);
        }
    }
    @Operation(summary = "添加/更新优惠活动的商品相关信息")
    @PostMapping("/Goods/UpdateGoodSpecialOffers")
    public String UpdateGoodSpecialOffers(@RequestParam("id") int id ){
        Map<String, Object> map = new HashMap<>();
        if (service.UpdateGoodsSpecialOffers(id)) {
            map.put("message","优惠活动添加成功");
            map.put("success",true);
        }else{

            map.put("message","优惠活动添加失败");
            map.put("success",false);
        }
        return JSON.toJSONString(map);
    }
    @Operation(summary = "删除id对应的每日优惠的值")
    @PostMapping("/Goods/DeleteGoodSpecialOffers")
    public String DeleteGoodSpecialOffers(@RequestParam("id")int id) {
        Map<String, Object> map = new HashMap<>();
        if (service.DeleteGoodSpecialOffers(id)) {
            map.put("message", "优惠活动删除成功");
            map.put("success", true);
        } else {
            map.put("message", "优惠活动删除失败");
            map.put("success", false);
        }
        return JSON.toJSONString(map);
    }
}
