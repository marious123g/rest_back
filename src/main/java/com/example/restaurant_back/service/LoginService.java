package com.example.restaurant_back.service;

public interface LoginService {
    boolean checkCustomPassword(String userName, String password);
    boolean checkStaffPassword(String userName, String password);
    String getUserGroup(String userName);
}
