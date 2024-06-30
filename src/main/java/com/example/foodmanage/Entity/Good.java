package com.example.foodmanage.Entity;

import lombok.Data;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
@Data
public class Good {
    int id;
    String name;
    BigDecimal price;
    String img;
    String descr;
    String origin;
    String taste;
    String specs;
    String date;
    String status;
    double discount;
    int business_id;
    int category_id;
    boolean dailySetMeal;
}
