package com.example.restaurant_back.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.restaurant_back.bean.Order;
import com.example.restaurant_back.bean.OrderDish;
import com.example.restaurant_back.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
//    使用params传递参数实际上还是通过url传递，url的长度是有限制的，因此报错，必须解决要用requestbody接收数组这个问题
//    后端@RequestBody要求json格式传输
//    最后采取直接把param放到前端的url里面，用String接收body然后通过json转化为实体
    public int addOrder(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "tableId") String tableId,
                        @RequestParam(value = "person") int person,
                        @RequestParam(value = "cost") double cost,
                        @RequestBody String dataList)
    {
        System.out.println("获取到下单用户："+userName+"&桌号："+tableId+"&用餐人数："+person);
//        就这么写，不要瞎改了
        List<OrderDish>dishList=(List<OrderDish>)JSONArray.parseArray(dataList,OrderDish.class);
        System.out.println("菜品："+JSON.toJSON(dishList)+"即将插入数据");
        return orderService.addOrder(userName,tableId,person,cost,dishList);
    }
    @RequestMapping("/custmFindOrder")
    public List<Order> custmFindOrder(@RequestParam(value = "tableId") String tableId)
    {
        System.out.println("读取到桌号"+tableId);
        return orderService.queryOrder(tableId);
    }
    @RequestMapping("/findOrderDish")
    public List<OrderDish>findOrderDish(@RequestParam(value = "orderId") int orderId)
    {
        System.out.println("读取到订单号"+orderId);
        return orderService.queryOrderDish(orderId);
    }
    @RequestMapping("/waiterFindOrder")
    public List<Order>waiterFindOrder()
    {
        return orderService.queryUnpaidOrder();
    }
    @RequestMapping("/findAllOrders")
    public List<Order>findAllOrders()
    {
        return orderService.findAllOrders();
    }
    @RequestMapping("/custmCheck")
    public int custmCheck(@RequestParam(value = "orderId") int orderId)
    {
        return orderService.custmCheck(orderId);
    }
}
