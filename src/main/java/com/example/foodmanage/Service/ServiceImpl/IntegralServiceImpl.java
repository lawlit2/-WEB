package com.example.foodmanage.Service.ServiceImpl;

import com.example.foodmanage.Mapper.IntegralMapper;
import com.example.foodmanage.Service.IntegralService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class IntegralServiceImpl implements IntegralService {
    @Resource
    IntegralMapper mapper;

    @Override
    public boolean AddIntegralById(int id, int integral) {
        return mapper.UpdateIntegralById(id, integral) == 1;
    }

    @Override
    public boolean DeleteIntegralById(int id) {
        return mapper.DeleteIntegralById(id) == 1;
    }

    @Override
    public int SelectIntegralById(int id) {
        Integer number = mapper.SelectIntegralById(id);
        if(number==null){
            return 0;
        }else {
            return number;
        }
    }
}
