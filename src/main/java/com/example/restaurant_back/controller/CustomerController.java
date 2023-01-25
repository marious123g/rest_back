package com.example.restaurant_back.controller;

import com.example.restaurant_back.bean.Customer;
import com.example.restaurant_back.serviceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping("/customerRegister")
//    @RequestBody Customer customer or @RequsetBody JSONObject object
    public int register(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password)
    {
        System.out.println("接收到请求");
        Customer customer=new Customer();
        customer.setUserName(userName);
        customer.setPassword(password);
        System.out.println("数据载入完毕，准备注册"+customer.getUserName());
        return customerService.customerRegister(customer);
    }

}
