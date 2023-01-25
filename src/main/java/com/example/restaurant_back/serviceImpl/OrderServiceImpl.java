package com.example.restaurant_back.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.example.restaurant_back.bean.Order;
import com.example.restaurant_back.bean.OrderDish;
import com.example.restaurant_back.bean.OrderDishExample;
import com.example.restaurant_back.bean.OrderExample;
import com.example.restaurant_back.mapper.OrderDishMapper;
import com.example.restaurant_back.mapper.OrderMapper;
import com.example.restaurant_back.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService
{

    @Resource
    OrderMapper orderMapper;
    @Resource
    OrderDishMapper orderDishMapper;

    @Override
    public int generateOrderId()
    {
        int temp= 1+(int)(Math.random()*(Math.pow(2,11)-2));
//        没有这个订单号才会停止
        while (orderMapper.selectByPrimaryKey(temp)!=null)
        {
            temp=1+(int)(Math.random()*(Math.pow(2,11)-2));
        }
        return temp;
    }

    @Override
    public int addOrder(String userName, String tableId, int person, double cost,List<OrderDish> dishList)
    {
        Order order=new Order();
        order.setUserName(userName);
        int orderId=generateOrderId();
        order.setOrderId(orderId);
        order.setTableNum(tableId);
        order.setPersonNum(person);
        order.setCost(cost);
//        这里一开始忘了写了，没试，不知道会不会出问题
        Date date=new Date();
        Timestamp timeStamp = new Timestamp(date.getTime()); // 让日期时间转换为数据库中的timestamp类型
        order.setCreateTime(timeStamp);

        System.out.println("插入订单基本信息"+ JSON.toJSONString(order));
        orderMapper.insert(order);
        for(int i=0;i<dishList.size();i++)
        {
//            逐个添加orderId
            OrderDish orderDish=(OrderDish) dishList.get(i);
            orderDish.setOrderId(orderId);
            orderDish.setTableId(tableId);
            orderDish.setStatus("烹饪中");
//            插入数据库
            System.out.println("插入第"+i+"条菜品信息："+JSON.toJSONString(orderDish));
            orderDishMapper.insertSelective(orderDish);
        }
//        给前台订单号，这是必须的
        return orderId;
    }

    @Override
    public List<Order> queryOrder(String tableId)
    {
        System.out.println("准备读取桌号："+tableId);
//        新建Example类
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria criteria=orderExample.createCriteria();
//        设置条件，本桌
        criteria.andTableNumEqualTo(tableId);
//        未结账
        criteria.andPayStatusIsNull();
        System.out.println("读取到本桌号的订单"+JSON.toJSONString(orderMapper.selectByExample(orderExample)));
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public List<OrderDish> queryOrderDish(int orderId)
    {
        System.out.println("准备读取订单号："+orderId);
        OrderDishExample orderDishExample=new OrderDishExample();
        OrderDishExample.Criteria criteria=orderDishExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        return orderDishMapper.selectByExample(orderDishExample);
    }

    @Override
    public List<Order> queryUnpaidOrder()
    {
        System.out.println("准备读取所有未结账订单");
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria criteria=orderExample.createCriteria();
//        只要null，就读
        criteria.andPayStatusIsNull();

        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public int custmCheck(int orderId)
    {
        Order order=orderMapper.selectByPrimaryKey(orderId);
        order.setPayStatus(true);
        return orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public List<Order> findAllOrders()
    {
        OrderExample orderExample=new OrderExample();
        return orderMapper.selectByExample(orderExample);
    }

}
