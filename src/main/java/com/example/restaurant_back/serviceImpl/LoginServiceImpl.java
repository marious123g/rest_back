package com.example.restaurant_back.serviceImpl;

import com.example.restaurant_back.bean.Customer;
import com.example.restaurant_back.bean.Staff;
import com.example.restaurant_back.mapper.CustomerMapper;
import com.example.restaurant_back.mapper.StaffMapper;
import com.example.restaurant_back.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {
    @Resource
    CustomerMapper customerMapper;
    @Resource
    StaffMapper staffMapper;


    @Override
    public boolean checkCustomPassword(String userName, String password) {
        Customer getCustomer = customerMapper.selectByPrimaryKey(userName);
        if(getCustomer == null){
            System.out.println("用户不存在");
            return false;
        }
        System.out.println("接收到："+password);
        System.out.println("正确密码为："+getCustomer.getPassword());
        return Objects.equals(getCustomer.getPassword(), password);
    }

    @Override
    public boolean checkStaffPassword(String userName, String password) {
        Staff getStaff = staffMapper.selectByPrimaryKey(userName);
        if(getStaff == null){
            System.out.println("用户不存在");
            return false;
        }
        System.out.println("接收到："+password);
        System.out.println("正确密码为："+getStaff.getPassword());
        return Objects.equals(getStaff.getPassword(), password);
    }

    @Override
    public String getUserGroup(String userName) {
        Staff getStaff = staffMapper.selectByPrimaryKey(userName);
        System.out.println("用户组："+getStaff.getJob());
        return getStaff.getJob();
    }
}
