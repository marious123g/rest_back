package com.example.restaurant_back.serviceImpl;

import java.util.*;
import com.example.restaurant_back.bean.Staff;
import com.example.restaurant_back.mapper.StaffMapper;
import com.example.restaurant_back.service.StaffService;
import com.example.restaurant_back.bean.StaffExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("StaffServiceImpl")
public class StaffServiceImpl implements StaffService
{
    @Resource
    StaffMapper staffMapper;
    @Override
    public List<Staff> getStaff()
    {
        StaffExample staffExample=new StaffExample();
        return staffMapper.selectByExample(staffExample);
    }

    @Override
    public int addStaff(String name, String job, String idNumber, String userName, String password)
    {
        Staff staff=new Staff();
        staff.setName(name);
        staff.setJob(job);
        staff.setIdNumber(idNumber);
        staff.setUserName(userName);
        staff.setPassword(password);

        return staffMapper.insertSelective(staff);
    }

    @Override
    public int deleteStaff(String userName)
    {
        return staffMapper.deleteByPrimaryKey(userName);
    }

    @Override
    public int updateStaff(String name, String job, String idNumber, String userName, String password)
    {
        Staff staff=new Staff();
        staff.setName(name);
        staff.setJob(job);
        staff.setIdNumber(idNumber);
        staff.setUserName(userName);
        staff.setPassword(password);
        return staffMapper.updateByPrimaryKeySelective(staff);
    }
}
