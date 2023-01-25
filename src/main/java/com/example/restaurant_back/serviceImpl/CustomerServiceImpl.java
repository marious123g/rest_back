package com.example.restaurant_back.serviceImpl;

import com.example.restaurant_back.bean.Customer;
import com.example.restaurant_back.bean.CustomerExample;
import com.example.restaurant_back.mapper.CustomerMapper;
import com.example.restaurant_back.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService
{

    @Resource
    CustomerMapper customerMapper;

    @Override
    public boolean validate(String name)
    {
//        读不出来用户名为name的记录，即为合法
        return (customerMapper.selectByPrimaryKey(name) == null);
    }

    @Override
    public int customerRegister(Customer customer)
    {
        System.out.println("开始检查用户名合法性："+validate(customer.getUserName()));
        if (validate(customer.getUserName()))
        {
            System.out.println("正在插入顾客数据");
            return customerMapper.insertSelective(customer);
        }
//        不合法，错误码114514
        else
            return 114514;
    }

}

