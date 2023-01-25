package com.example.restaurant_back.service;

import java.util.ArrayList;
import java.util.Map;

public interface CommonService {
    Map<String,String> getPersonInfo(String userName);
    ArrayList<Map<String,String>> getNotice();
}
