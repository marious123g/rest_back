package com.example.restaurant_back.controller;


import com.example.restaurant_back.serviceImpl.CommonServiceImpl;
import com.example.restaurant_back.serviceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CommonController {
    @Autowired
    private CommonServiceImpl commonService;

    @RequestMapping("/getpersoninfo")
    public Map<String,String> getPersonInfo(@RequestParam(value = "userName") String userName)
    {
        System.out.println("开始读取用户个人信息："+userName);
        return commonService.getPersonInfo(userName);
    }
    @RequestMapping("/checknotice")
    public ArrayList<Map<String,String>> checkNotice()
    {
        System.out.println("开始读取公告信息。");
        return commonService.getNotice();
    }
    @RequestMapping("/getorderdetail")
    public ArrayList<Map<String,String>> getOrderDetail()
    {
        System.out.println("开始传输”订单详情“数据");
        ArrayList<Map<String,String>> postsAll=new ArrayList<>();
        postsAll.add(new HashMap<String,String>(){
            {

                put("name", "宫保鸡丁");
                put("num", "2");
                put("price", "5.00");
                put("cost","10.00" );
            }
        });
        return postsAll;
    }
}
