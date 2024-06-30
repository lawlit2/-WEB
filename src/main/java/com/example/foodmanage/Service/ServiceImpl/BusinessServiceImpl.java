package com.example.foodmanage.Service.ServiceImpl;

import com.example.foodmanage.Entity.BusinessMessage;
import com.example.foodmanage.Mapper.BusinessMapper;
import com.example.foodmanage.Service.BusinessService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Resource
    BusinessMapper mapper;
    @Override
    public BusinessMessage SelectBusinessByAddress(String address) {
        return mapper.SelectBusinessByAddress(address);
    }

    @Override
    public String SelectDeliveryTime(int id) {
        try {
            String s = mapper.SelectDeliveryTime(id);
            return Objects.requireNonNullElse(s, "null");
        }catch (NullPointerException e){
            return "null";
        }
    }
    @Override
    public boolean DeleteDeliveryTime(int id) {
        Integer integer = mapper.DeleteDeliveryTime(id);
        return integer != null;
    }

    @Override
    public boolean UpdateDeliveryTime(String time, int id) {
        Integer integer = mapper.UpdateDeliveryTime(time,id);
        return integer != null;
    }

    @Override
    public boolean UpdateTimeWindow(String time, int id) {
        Integer integer = mapper.UpdateTimeWindow(time, id);
        return integer != null;
    }

    @Override
    public boolean DeleteTimeWindow(int id) {
        Integer integer = mapper.DeleteTimeWindow(id);
        return integer!=null;
    }

    @Override
    public String SelectTimeWindow(int id) {
        try{
            String s = mapper.SelectTimeWindow(id);
            if(s == null){
                return "null";
            }
            return  s;
        }catch (Exception e){
            return  "null";
        }
    }


}
