package com.example.restaurant_back.controller;

import com.example.restaurant_back.bean.Dish;
import com.example.restaurant_back.serviceImpl.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin
public class DishController {

    @Autowired
    private DishServiceImpl dishService;

    @RequestMapping("/getMainCourse")
    public List<Dish> getMainCourse()
    {
        System.out.println("收到请求，正在获取主菜");
//        System.out.println("获取到主菜："+dishService.findMainCourse());
        return dishService.findMainCourse();
    }

    @RequestMapping("/getDrink")
    public List<Dish>getDrink()
    {
        System.out.println("收到请求，正在获取饮料");
        return dishService.findDrink();
    }

    @RequestMapping("/getSnack")
    public List<Dish>getSnack()
    {
        System.out.println("收到请求，正在获取小吃");
        return dishService.findSnack();
    }
    @RequestMapping("/getAllDish")
    public List<Dish>getAllDish()
    {
        return dishService.getAllDish();
    }
    @RequestMapping("/addDish")
    public int addDish(@RequestParam(value = "name") String name,
                       @RequestParam(value = "price") double price,
                       @RequestParam(value = "category") int category,
                       @RequestParam(value = "image") String image)
    {
        return dishService.addDish(name,price,category,image);
    }
    @RequestMapping("/updateDish")
    public int updateDish(@RequestParam(value = "name") String name,
                      @RequestParam(value = "price") double price,
                      @RequestParam(value = "category") int category,
                      @RequestParam(value = "image") String image)
    {
        return dishService.updateDish(name,price,category,image);
    }
    @RequestMapping("/deleteDish")
    public int deleteDish(@RequestParam(value = "name")String name)
    {
        return dishService.deleteDish(name);
    }
}
