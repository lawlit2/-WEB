package com.example.foodmanage.Service.ServiceImpl;


import com.example.foodmanage.Mapper.OrdersMapper;
import com.example.foodmanage.Service.OrderService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrderService {
    @Mapper
    OrdersMapper mapper;
    @Override
    public boolean AddProductTimeById(String time, int id) {
        Integer integer = mapper.UpdateProductTime(time, id);
        if(integer==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String SelectProductTimeById(int id) {

        try{
            String s = mapper.SelectTimeById(id);
            return s;
        }catch (NullPointerException e){
            return "null";
        }

    }

    @Override
    public boolean DeleteProductTimeById(int id) {
        Integer integer = mapper.DeleteProductTime(id);
        if(integer == null){
            return false;
        }else return  true;
    }
}
