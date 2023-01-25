package com.example.restaurant_back.controller;

import com.example.restaurant_back.bean.DishSales;
import com.example.restaurant_back.serviceImpl.ManageDataServiceImpl;
import com.example.restaurant_back.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin
public class ManageDataController
{
    @Autowired
    private ManageDataServiceImpl manageDataService;

    @RequestMapping("/getTotalIncome")
    public double getTotalIncome(@RequestParam(value = "startDate") String startDate,
                                 @RequestParam(value = "endDate") String endDate)
    {
        System.out.println(startDate);
        Timestamp start=Timestamp.valueOf(startDate);
        Timestamp end=Timestamp.valueOf(endDate);
        return manageDataService.getTotalIncome(start,end);
    }
    @RequestMapping("/getOrderNum")
    public int getOrderNum(@RequestParam(value = "startDate") String startDate,
                           @RequestParam(value = "endDate") String endDate)
    {
        Timestamp start=Timestamp.valueOf(startDate);
        Timestamp end=Timestamp.valueOf(endDate);
        return manageDataService.getOrderNum(start,end);
    }
    @RequestMapping("/getDishSales")
    public List<DishSales>getDishSales(@RequestParam(value = "startDate") String startDate,
                                       @RequestParam(value = "endDate") String endDate)
    {
        Timestamp start=Timestamp.valueOf(startDate);
        Timestamp end=Timestamp.valueOf(endDate);
        return manageDataService.getDishSales(start,end);
    }
}
