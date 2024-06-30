package com.example.foodmanage.Service;

import com.example.foodmanage.Entity.BusinessMessage;
import org.springframework.stereotype.Service;


public interface BusinessService {
    BusinessMessage SelectBusinessByAddress(String address);
    String SelectDeliveryTime(int id);
    boolean DeleteDeliveryTime(int id);
    boolean UpdateDeliveryTime(String time,int id);
    boolean UpdateTimeWindow(String time,int id);
    boolean DeleteTimeWindow(int id);
    String SelectTimeWindow(int id);
}
