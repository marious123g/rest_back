package com.example.restaurant_back.controller;

import com.example.restaurant_back.bean.Notice;
import com.example.restaurant_back.service.ManageNoticeService;
import com.example.restaurant_back.serviceImpl.ManageDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    ManageNoticeService manageNoticeService;
    @RequestMapping("/addNotice")
    public int addNotice(@RequestParam(value = "content") String content)
    {
        System.out.println("接收到新增公告请求");

        return manageNoticeService.addNotice(content);
    }
    @RequestMapping("/deleteNotice")
    public int deleteNotice(@RequestParam (value = "noticeId") int noticeId)
    {
        return manageNoticeService.deleteNotice(noticeId);
    }

    @RequestMapping("/getmanagenotice")
    public List<Notice> getAllNotice()
    {
        System.out.println("开始传输”公告管理“数据");
        return manageNoticeService.getAllNotice();
    }
    @RequestMapping("/getmanagestaff")
    public ArrayList<Map<String,String>> getStaff()
    {
        System.out.println("开始传输”员工管理“数据");
        ArrayList<Map<String,String>> postsAll=new ArrayList<>();
        postsAll.add(new HashMap<String,String>(){
            {
                put("name", "打工人1");
                put("job", "服务员");
                put("id","71119" );
                put("account","yangqiang" );
                put("password","yang123" );
            }
        });
        postsAll.add(new HashMap<String,String>(){
            {
                put("name", "打工人2");
                put("job", "服务员");
                put("id","71119" );
                put("account","qiangyang" );
                put("password","qiang123" );
            }
        });
        return postsAll;
    }

    @RequestMapping("/getmanagedishes")
    public ArrayList<Map<String,String>> getManageDishes()
    {
        System.out.println("开始传输”菜品管理“数据");
        ArrayList<Map<String,String>> postsAll=new ArrayList<>();
        postsAll.add(new HashMap<String,String>(){
            {
                put("name", "宫保鸡丁");
                put("price", "5.00");
                put("describe","123" );
            }
        });
        return postsAll;
    }
}
