package com.example.foodmanage.Entity;

import lombok.Data;

@Data
public class User {
    int id;
    String username;
    String password;
    String name;
    String avatar;
    String role;
    String sex;
    String phone;
    int integral;
}
