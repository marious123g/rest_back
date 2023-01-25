package com.example.restaurant_back.service;

import com.example.restaurant_back.bean.Staff;
import java.util.*;

public interface StaffService
{
    public List<Staff> getStaff();
    public int addStaff(String name,String job,String idNumber,String userName,String password);
    public int deleteStaff(String userName);
    public int updateStaff(String name,String job,String idNumber,String userName,String password);
}
