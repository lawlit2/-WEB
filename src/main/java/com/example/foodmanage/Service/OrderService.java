package com.example.foodmanage.Service;

public interface OrderService {
    boolean AddProductTimeById(String time,int id);
    String SelectProductTimeById(int id);
    boolean DeleteProductTimeById(int id);
}
