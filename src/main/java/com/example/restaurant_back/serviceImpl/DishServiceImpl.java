package com.example.restaurant_back.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.example.restaurant_back.bean.Dish;
import com.example.restaurant_back.bean.DishExample;
import com.example.restaurant_back.mapper.DishMapper;
import com.example.restaurant_back.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("DishServiceImpl")
public class DishServiceImpl implements DishService
{

    @Resource
    private DishMapper dishMapper;

    @Override
    public List<Dish> findMainCourse()
    {
//        这个example类不能放到成员变量里，不然结果全一样，不知道为啥也
        DishExample dishExample = new DishExample();
        DishExample.Criteria criteria = dishExample.createCriteria();
        criteria.andCategoryEqualTo(1);
        System.out.println("读取到主菜" + JSON.toJSONString(dishMapper.selectByExample(dishExample)));
        return dishMapper.selectByExample(dishExample);
    }

    @Override
    public List<Dish> findDrink()
    {
        DishExample dishExample = new DishExample();
        DishExample.Criteria criteria = dishExample.createCriteria();
        criteria.andCategoryEqualTo(3);
        System.out.println("读取到饮料" + JSON.toJSONString(dishMapper.selectByExample(dishExample)));
        return dishMapper.selectByExample(dishExample);
    }

    @Override
    public List<Dish> findSnack()
    {
        DishExample dishExample = new DishExample();
        DishExample.Criteria criteria = dishExample.createCriteria();
        criteria.andCategoryEqualTo(2);
        System.out.println("读取到小吃" + JSON.toJSONString(dishMapper.selectByExample(dishExample)));
        return dishMapper.selectByExample(dishExample);
    }

    @Override
    public List<Dish> getAllDish()
    {
        DishExample dishExample=new DishExample();

        return dishMapper.selectByExample(dishExample);
    }

    @Override
    public int addDish(String name,double price,int category,String image)
    {
        Dish dish=new Dish();
        dish.setName(name);
        dish.setPrice(price);
        dish.setCategory(category);
        dish.setImage(image);
        return dishMapper.insertSelective(dish);
    }

    @Override
    public int deleteDish(String name)
    {
        return dishMapper.deleteByPrimaryKey(name);
    }

    @Override
    public int updateDish(String name,double price,int category,String image)
    {
        Dish dish=new Dish();
        dish.setName(name);
        dish.setPrice(price);
        dish.setCategory(category);
        dish.setImage(image);
        return dishMapper.updateByPrimaryKeySelective(dish);
    }
}
