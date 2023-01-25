package com.example.restaurant_back.service;

import com.example.restaurant_back.bean.Order;
import com.example.restaurant_back.bean.OrderDish;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
    public int generateOrderId();
    public int addOrder(String userName,String tableId,int person,double cost, List<OrderDish>dishList);
    public List<Order> queryOrder(String tableId);
    public List<OrderDish>queryOrderDish(int orderId);
    public List<Order>queryUnpaidOrder();
    public int custmCheck(int orderId);
    public List<Order>findAllOrders();
}
