package com.example.restaurant_back.service;

import com.example.restaurant_back.bean.OrderDish;
import com.example.restaurant_back.bean.OrderDishExample;

import java.util.ArrayList;
import java.util.Map;

public interface WaiterService {
    ArrayList<Map<String,String>> getDishInfo();
    void changeDishInfo(OrderDish orderDish, OrderDishExample orderDishExample);
}
