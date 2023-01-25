package com.example.restaurant_back.service;

import com.example.restaurant_back.bean.Customer;

public interface CustomerService {
    public boolean validate(String name);
    public int customerRegister(Customer customer);

}
