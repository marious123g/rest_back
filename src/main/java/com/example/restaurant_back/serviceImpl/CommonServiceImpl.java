package com.example.restaurant_back.serviceImpl;

import com.example.restaurant_back.bean.Notice;
import com.example.restaurant_back.bean.Staff;
import com.example.restaurant_back.mapper.NoticeMapper;
import com.example.restaurant_back.mapper.StaffMapper;
import com.example.restaurant_back.service.CommonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service("CommonServiceImpl")
public class CommonServiceImpl implements CommonService {
    @Resource
    StaffMapper staffMapper;
    @Resource
    NoticeMapper noticeMapper;


    @Override
    public Map<String, String> getPersonInfo(String userName) {
        Staff getStaff = staffMapper.selectByPrimaryKey(userName);
        HashMap<String,String> map=new HashMap<>();
        map.put("imageUrl", getStaff.getPortrait());
        map.put("email", getStaff.getEmail());
        map.put("address", getStaff.getAddress());
        map.put("name", getStaff.getName());
        map.put("phonenum", getStaff.getTel());
        map.put("id", getStaff.getIdNumber());
        map.put("registerdate", getStaff.getRegisterDate());
        return map;
    }

    @Override
    public ArrayList<Map<String, String>> getNotice()
    {
        return null;
    }


}
