package com.example.foodmanage.Service.ServiceImpl;

import com.example.foodmanage.Entity.User;
import com.example.foodmanage.Mapper.UserMapper;
import com.example.foodmanage.Service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper mapper;
    @Override
    public boolean JudgementUser(String phone,String password) {
       User user = mapper.SelectUserById(phone, password);
        return user != null;
    }
}
