package com.example.foodmanage.Service;

import com.example.foodmanage.Entity.Good;

import java.math.BigDecimal;
import java.util.List;

public interface GoodService {
    List<Good> SelectDailySetMeal();
    boolean UpdateDailySetMeal(int id);
    boolean DeleteDailySetMeal(int id);
    BigDecimal SelectDollar(int id);
    boolean UpdateDollar(BigDecimal dollar,int id);
    boolean DeleteDollar(int id);
    List<Good> SelectOrderBySpecialOffers();
    boolean UpdateGoodsSpecialOffers(int id);
    boolean DeleteGoodSpecialOffers(int id);
}
