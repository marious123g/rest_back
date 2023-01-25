package com.example.restaurant_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.restaurant_back.bean.Staff;
import com.example.restaurant_back.serviceImpl.StaffServiceImpl;

@RestController
@CrossOrigin
public class StaffController
{
    @Autowired
    private StaffServiceImpl staffService;

    @RequestMapping("/getAllStaff")
    public List<Staff> getStaff()
    {
        System.out.println("收到请求，正在获取员工");
        return staffService.getStaff();
    }

    @RequestMapping("/addStaff")
    public int addStaff(
            @RequestParam(value= "name") String name,
            @RequestParam(value="job") String job,
            @RequestParam(value="idNumber") String idNumber,
            @RequestParam(value="userName") String userName,
            @RequestParam(value="password") String password)
    {
        return staffService.addStaff(name,job,idNumber,userName,password);
    }

    @RequestMapping("/updateStaff")
    public int updateStaff(@RequestParam(value= "name") String name,
                           @RequestParam(value="job") String job,
                           @RequestParam(value="idNumber") String idNumber,
                           @RequestParam(value="userName") String userName,
                           @RequestParam(value="password") String password)
    {
        return staffService.updateStaff(name,job,idNumber,userName,password);
    }

    @RequestMapping("/deleteStaff")
    public int deleteStaff(@RequestParam(value="userName") String idNumber)
    {
        return staffService.deleteStaff(idNumber);
    }
}
