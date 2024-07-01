package com.example.foodmanage.Service.ServiceImpl;

import com.example.foodmanage.Entity.Good;
import com.example.foodmanage.Mapper.GoodsMapper;
import com.example.foodmanage.Service.GoodService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Resource
    GoodsMapper mapper;
    @Override
    public List<Good> SelectDailySetMeal() {
        return mapper.SelectDailySetMeal();
    }

    @Override
    public boolean UpdateDailySetMeal(int id) {
        Integer integer = mapper.UpdateDailySetMeal(id);
        return integer != null;
    }

    @Override
    public boolean DeleteDailySetMeal(int id) {
        Integer integer = mapper.DeleteDailySetMeal(id);
        return integer != null;
    }

    @Override
    public BigDecimal SelectDollar(int id) {
        return mapper.SelectDollar(id);
    }

    @Override
    public boolean UpdateDollar(BigDecimal dollar, int id) {
        Integer integer = mapper.UpdateDollar(dollar, id);
        return integer!=null;
    }

    @Override
    public boolean DeleteDollar(int id) {
        Integer integer = mapper.DeleteDollar(id);
        return integer!=null;
    }

    @Override
    public List<Good> SelectOrderBySpecialOffers() {
        return mapper.SelectOrderBySpecialOffers();
    }

    @Override
    public boolean UpdateGoodsSpecialOffers(int id) {
        Integer integer = mapper.UpdateGoodsSpecialOffers(id);
        return integer!=null;
    }

    @Override
    public boolean DeleteGoodSpecialOffers(int id) {
        Integer integer = mapper.DeleteGoodSpecialOffers(id);
        return integer!=null;
    }
}
