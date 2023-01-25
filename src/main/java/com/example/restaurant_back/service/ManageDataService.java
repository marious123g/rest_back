package com.example.restaurant_back.service;

import com.example.restaurant_back.bean.DishSales;

import java.sql.Timestamp;
import java.util.List;

public interface ManageDataService
{
    public double getTotalIncome(Timestamp startTime,Timestamp endTime);
    public int getOrderNum(Timestamp startTime,Timestamp endTime);
    public List<DishSales>getDishSales(Timestamp startTime,Timestamp endTime);
}
