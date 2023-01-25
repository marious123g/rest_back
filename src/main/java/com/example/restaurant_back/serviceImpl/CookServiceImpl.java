package com.example.restaurant_back.serviceImpl;

import com.example.restaurant_back.bean.OrderDish;
import com.example.restaurant_back.bean.OrderDishExample;
import com.example.restaurant_back.mapper.OrderDishMapper;
import com.example.restaurant_back.service.CookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("CookServiceImpl")
public class CookServiceImpl implements CookService {
    @Resource
    OrderDishMapper orderDishMapper;

    @Override
    public ArrayList<Map<String, String>> getDishInfo() {
        ArrayList<Map<String,String>> postsAll=new ArrayList<>();
        OrderDishExample orderDishExample=new OrderDishExample();
        List<OrderDish> getDishes = orderDishMapper.selectByExample(orderDishExample);
        for(OrderDish getDish : getDishes) {
            System.out.println("发现菜品订单");
            if(Objects.equals(getDish.getStatus(), "烹饪中"))
                postsAll.add(new HashMap<String,String>(){
                    {
                        put("f1", getDish.getName());
                        put("f2", getDish.getAmount().toString());
                        put("f3", getDish.getTableId());
                        put("f4", getDish.getOrderId().toString());
                    }
                });
        }
        return postsAll;
    }

    @Override
    public void changeDishInfo(OrderDish orderDish, OrderDishExample orderDishExample) {
        orderDishMapper.updateByExampleSelective(orderDish, orderDishExample);
    }
}
