package com.example.foodmanage.Service.ServiceImpl;

import com.example.foodmanage.Entity.BusinessMessage;
import com.example.foodmanage.Mapper.BusinessMapper;
import com.example.foodmanage.Service.BusinessService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Resource
    BusinessMapper mapper;
    @Override
    public BusinessMessage SelectBusinessByAddress(String address) {
        return mapper.SelectBusinessByAddress(address);
    }


}
