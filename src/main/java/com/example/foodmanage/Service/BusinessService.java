package com.example.foodmanage.Service;

import com.example.foodmanage.Entity.BusinessMessage;
import org.springframework.stereotype.Service;


public interface BusinessService {
    BusinessMessage SelectBusinessByAddress(String address);

}
