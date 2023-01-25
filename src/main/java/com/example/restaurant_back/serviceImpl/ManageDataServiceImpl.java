package com.example.restaurant_back.serviceImpl;

import com.example.restaurant_back.bean.*;
import com.example.restaurant_back.mapper.DishMapper;
import com.example.restaurant_back.mapper.OrderDishMapper;
import com.example.restaurant_back.mapper.OrderMapper;
import com.example.restaurant_back.service.ManageDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@Service("ManageDataServiceImpl")
public class ManageDataServiceImpl implements ManageDataService
{
    @Resource
    OrderMapper orderMapper;
    @Resource
    DishMapper dishMapper;
    @Resource
    OrderDishMapper orderDishMapper;

    @Override
    public double getTotalIncome(Timestamp startTime, Timestamp endTime)
    {
        OrderExample example=new OrderExample();
        OrderExample.Criteria criteria=example.createCriteria();
        criteria.andCreateTimeBetween(startTime,endTime);
        List<Order> orderList=orderMapper.selectByExample(example);
        double totalIncome=0;
        for (int i=0;i<orderList.size();i++)
        {
            totalIncome+=orderList.get(i).getCost();
        }
        return totalIncome;
    }

    @Override
    public int getOrderNum(Timestamp startTime, Timestamp endTime)
    {
        OrderExample example=new OrderExample();
        OrderExample.Criteria criteria=example.createCriteria();
        criteria.andCreateTimeBetween(startTime,endTime);
        List<Order> orderList=orderMapper.selectByExample(example);
        return orderList.size();
    }

    @Override
    public List<DishSales> getDishSales(Timestamp startTime, Timestamp endTime)
    {
//        把菜品全读出来
        DishExample dishExample=new DishExample();
        List<Dish>dishList=dishMapper.selectByExample(dishExample);
//        开一个和菜品列表对应的DishSales列表
        List<DishSales>dishSalesList=new ArrayList<>();
//        首先是长度和dishList相同
        for(int i=0;i<dishList.size();i++)
        {
            DishSales temp=new DishSales();
//            先把名字对应起来
            temp.setName(dishList.get(i).getName());
//            数量初始化为0
            temp.setAmount(0);
            dishSalesList.add(temp);
        }
//        把这段时间的订单都拿出来，真他娘的麻烦我就应该在orderDish里面加一个时间字段的
        OrderExample example=new OrderExample();
        OrderExample.Criteria criteria=example.createCriteria();
        criteria.andCreateTimeBetween(startTime,endTime);
        List<Order> orderList=orderMapper.selectByExample(example);
//        把拿出来的订单的对应的菜品全拿出来
        List<OrderDish>orderDishList=new ArrayList<>();
        for (int i=0;i<orderList.size();i++)
        {
            OrderDishExample orderDishExample=new OrderDishExample();
            OrderDishExample.Criteria criteria1=orderDishExample.createCriteria();
            criteria.andOrderIdEqualTo(orderList.get(i).getOrderId());
            List<OrderDish>temp=orderDishMapper.selectByExample(orderDishExample);
//            我也不知道行不行，干了
//            拼接起来
            orderDishList.addAll(temp);
//           当你的程序以一种奇怪的方式跑起来，就不要动了
            break;
        }
//        System.out.println("orderList的长度"+orderList.size()+"dishSalesList的长度"+dishSalesList.size());
//        外层循环是dishSalesList，每当dishSalesList的游标向后移动一个，就要遍历一次orderDishList寻找对应名字菜品的订单记录
        for (int i=0;i<dishSalesList.size();i++)
        {
            System.out.println("现在查询菜名"+dishSalesList.get(i).getName());
            for (int j=0;j<orderDishList.size();j++)
            {
//                不用equals会出现灾难哦
                if(dishSalesList.get(i).getName().equals(orderDishList.get(j).getName()))
                {
//                    数量+=订单菜品中某条记录的amount
                    System.out.println("现在dishSalesList[i]的数量："+dishSalesList.get(i).getAmount()+"需要增加："+orderDishList.get(j).getAmount());
                    dishSalesList.get(i).increaseAmount(orderDishList.get(j).getAmount());
                    System.out.println("now:"+dishSalesList.get(i).getAmount());
                }
            }
        }

        return dishSalesList;
    }
}
