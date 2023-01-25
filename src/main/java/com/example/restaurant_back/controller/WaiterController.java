package com.example.restaurant_back.controller;


import com.example.restaurant_back.bean.OrderDish;
import com.example.restaurant_back.bean.OrderDishExample;
import com.example.restaurant_back.service.WaiterService;
import com.example.restaurant_back.serviceImpl.CommonServiceImpl;
import com.example.restaurant_back.serviceImpl.DishServiceImpl;
import com.example.restaurant_back.serviceImpl.WaiterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WaiterController {
    @Autowired
    private WaiterServiceImpl waiterService;

    @RequestMapping("/getServeDishes")
    public ArrayList<Map<String,String>> getServeDishes()
    {
        System.out.println("开始传输”服务员上菜“数据");
        return waiterService.getDishInfo();
    }

    @RequestMapping("/changeServeDishes")
    public void changeServeDishes(@RequestParam(value = "orderID") int orderID, @RequestParam(value = "name") String name)
    {
        System.out.println("服务员完成上菜");
        OrderDish orderDish = new OrderDish();//要修改的内容
        orderDish.setStatus("用餐中");
        OrderDishExample orderDishExample = new OrderDishExample();//要查询的依照
        OrderDishExample.Criteria criteria=orderDishExample.createCriteria();
        criteria.andOrderIdEqualTo(orderID);
        criteria.andNameEqualTo(name);
        waiterService.changeDishInfo(orderDish, orderDishExample);
    }
}
