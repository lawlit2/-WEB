package com.example.foodmanage.Controller;

import com.alibaba.fastjson2.JSON;
import com.example.foodmanage.Entity.OrderInfo;
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
    @PostMapping("/Orders/UpdateDeliveryDate")
    public String UpdateDeliveryDate(@RequestParam("deliveryDate") String date,
                                     @RequestParam("id")int id){
        Map<String, Object> result = new HashMap<>();
        if (service.UpdateDeliverDate(date,id)) {
            result.put("message","配送日期添加/修改成功");
            result.put("success",true);
        }else{
            result.put("message","配送日期添加/修改失败" );
            result.put("success",false);
        }
        return JSON.toJSONString(result);
    }
    @PostMapping("/Orders/SelectDeliverDate")
    public String SelectDeliveryDate(@RequestParam("id")int id){
        Map<String,Object> result = new HashMap<>();
        result.put("配送日期",service.SelectDeliverDate(id));
        return JSON.toJSONString(result);
    }
    @PostMapping("/Orders/DeleteDeliverDate")
    public String DeleteDeliveryDate(@RequestParam("id")int id){
        Map<String,Object> result = new HashMap<>();
        if (service.DeleteDeliverDate(id)) {
            result.put("message","配送日期删除成功");
            result.put("success",true);
        }else{
            result.put("message","配送日期删除失败");
            result.put("success",false);
        }
        return JSON.toJSONString(result);
    }

    @PostMapping("/Orders/SelectOrderInfo")
    public String SelectOrderInfo(@RequestParam("id")int id){
        OrderInfo orderInfo = service.selectOrderInfo(id);
        if(orderInfo==null){
            Map<String ,String > map = new HashMap<>();
            map.put("message","未找到对应的订单信息");
            return JSON.toJSONString(map);
        }
        return JSON.toJSONString(orderInfo);
    }
    @PostMapping("/Orders/DeleteOrderInfo")
    public String DeleteOrderInfo(@RequestParam("id")int id){
        Map<String,Object> result = new HashMap<>();
        if (service.DeleteOrderInfo(id)) {
            result.put("message","订单信息删除成功");
            result.put("success",true);
        }else{
            result.put("message","订单信息删除失败");
            result.put("success",false);
        }
        return JSON.toJSONString(result);
    }
    @PostMapping("/Orders/UpdateOrderInfo")
    public String UpdateOrderInfo(@RequestParam("id")int  id,
                                  @RequestParam("merchantPhone")String merchantPhone,
                                  @RequestParam("deliveryPhone")String deliveryPhone,
                                  @RequestParam("estimatedDeliveryTime")String estimatedDeliveryTime){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setDeliveryPhone(deliveryPhone);
        orderInfo.setMerchantPhone(merchantPhone);
        orderInfo.setEstimatedDeliveryTime(estimatedDeliveryTime);
        Map<String,Object> result = new HashMap<>();
        if (service.updateOrderInfo(orderInfo,id)) {
            result.put("message","订单信息添加成功");
            result.put("success",true);
        }else{
            result.put("message","订单信息添加失败");
            result.put("success",false);
        }
        return JSON.toJSONString(result);
    }

}
