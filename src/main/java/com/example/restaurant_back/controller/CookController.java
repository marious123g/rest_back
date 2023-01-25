package com.example.restaurant_back.controller;

import com.example.restaurant_back.bean.OrderDish;
import com.example.restaurant_back.bean.OrderDishExample;
import com.example.restaurant_back.serviceImpl.CookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CookController {
    @Autowired
    private CookServiceImpl cookService;

    @RequestMapping("/getReserveDishes")
    public ArrayList<Map<String,String>> getReserveDishes()
    {
        System.out.println("开始传输”后厨订单“数据");
        return cookService.getDishInfo();

    }

    @RequestMapping("/changeReserveDishes")
    public void changeReserveDishes(@RequestParam(value = "orderID") int orderID, @RequestParam(value = "name") String name)
    {
        System.out.println("后厨完成制作，开始上菜");
        OrderDish orderDish = new OrderDish();//要修改的内容
        orderDish.setStatus("上菜中");
        OrderDishExample orderDishExample = new OrderDishExample();//要查询的依照
        OrderDishExample.Criteria criteria=orderDishExample.createCriteria();
        criteria.andOrderIdEqualTo(orderID);
        criteria.andNameEqualTo(name);
        cookService.changeDishInfo(orderDish, orderDishExample);
    }
}
