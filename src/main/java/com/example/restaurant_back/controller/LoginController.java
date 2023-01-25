package com.example.restaurant_back.controller;

import com.example.restaurant_back.service.LoginService;
import com.example.restaurant_back.serviceImpl.CustomerServiceImpl;
import com.example.restaurant_back.serviceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping("/checkCustomPassword")
    public boolean checkCustomerPassword(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password)
    {
        System.out.println("检查顾客密码，接收到用户名：" + userName);
        return loginService.checkCustomPassword(userName, password);
    }

    @RequestMapping("/checkStaffPassword")
    public boolean checkStaffPassword(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password)
    {
        System.out.println("检查员工密码，接收到用户名：" + userName);
        return loginService.checkStaffPassword(userName, password);
    }

    @RequestMapping("/getUserGroup")
    public String getUserGroup(@RequestParam(value = "userName") String userName)
    {
        System.out.println("检查员工密码，接收到用户名：" + userName);
        return loginService.getUserGroup(userName);
    }
}
