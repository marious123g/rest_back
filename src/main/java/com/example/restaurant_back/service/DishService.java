package com.example.restaurant_back.service;

import com.example.restaurant_back.bean.Dish;

import java.util.List;

public interface DishService {
    public List<Dish> findMainCourse();
    public List<Dish> findDrink();
    public List<Dish> findSnack();
    public List<Dish> getAllDish();
    public int addDish(String name,double price,int category,String image);
    public int deleteDish(String name);
    public int updateDish(String name,double price,int category,String image);

}
