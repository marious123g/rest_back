package com.example.restaurant_back.service;

import com.example.restaurant_back.bean.Notice;

import java.util.List;

public interface ManageNoticeService
{
    public List<Notice>getAllNotice();
    public int addNotice(String content);
    public int deleteNotice(int noticeId);
}
