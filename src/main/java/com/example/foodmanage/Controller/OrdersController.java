package com.example.foodmanage.Controller;

import com.alibaba.fastjson2.JSON;
import com.example.foodmanage.Entity.Order;
import com.example.foodmanage.Entity.OrderInfo;
import com.example.foodmanage.Service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Tag(name = "{order}订单相关接口")
@RestController
public class OrdersController {
    @Resource
    OrderService service;
    @Operation(summary = "添加/修改下次配送时间")
    @PostMapping("/Orders/AddTime")
    public String AddProductTime(@Parameter(description = "下次配送时间")@RequestParam("FollowUpProductTime") String time,
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
    @Operation(summary = "查询下次配送时间")
    @PostMapping("/Orders/SelectTime")
    public String SelectProductTime(@RequestParam("id") int id){
        String s = service.SelectProductTimeById(id);
        Map<String, Object> result = new HashMap<>();
        result.put("下次配送时间",s);
        return JSON.toJSONString(result);
    }
    @Operation(summary = "删除下次配送时间对应的值")
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
    @Operation(summary = "更新/添加配送日期")
    @PostMapping("/Orders/UpdateDeliveryDate")
    public String UpdateDeliveryDate(@Parameter(description = "配送时间")@RequestParam("deliveryDate") String date,
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
    @Operation(summary = "查询配送日期")
    @PostMapping("/Orders/SelectDeliverDate")
    public String SelectDeliveryDate(@RequestParam("id")int id){
        Map<String,Object> result = new HashMap<>();
        result.put("配送日期",service.SelectDeliverDate(id));
        return JSON.toJSONString(result);
    }
    @Operation(summary = "删除配送日期")
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
    @Operation(summary = "查询商家电话，送餐电话，预计送餐时间")
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
    @Operation(summary = "删除商家电话，送餐电话，预计送餐时间")
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
    @Operation(summary = "更新/添加商家电话，送餐电话，预计送餐时间")
    @PostMapping("/Orders/UpdateOrderInfo")
    public String UpdateOrderInfo(@RequestParam("id")int  id,
                                  @Parameter (description = "商家电话")@RequestParam("merchantPhone")String merchantPhone,
                                  @Parameter (description = "送餐电话")@RequestParam("deliveryPhone")String deliveryPhone,
                                  @Parameter (description = "预计送餐时间")@RequestParam("estimatedDeliveryTime")String estimatedDeliveryTime){
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
    @Operation(summary = "通过商家id找到对应的订单信息")
    @PostMapping("/Orders/SelectOrderByBusinessId")
    public String SelectOrderByBusinessID(@Parameter(description = "商家ID") @RequestParam("business_id") int business_id){
        List<Order> orders = service.SelectOrdersByBusinessID(business_id);
        if(orders==null){
            Map<String,Object> result = new HashMap<>();
            result.put("message","未找到相关信息");
            return JSON.toJSONString(result);
        }else{
            return JSON.toJSONString(orders);
        }
    }
}
