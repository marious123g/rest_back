package com.example.restaurant_back.serviceImpl;


import com.example.restaurant_back.bean.Notice;
import com.example.restaurant_back.bean.NoticeExample;
import com.example.restaurant_back.mapper.NoticeMapper;
import com.example.restaurant_back.service.ManageNoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Service("ManageNoticeServiceImpl")
public class ManageNoticeServiceImpl implements ManageNoticeService
{
    @Resource
    NoticeMapper noticeMapper;
    @Override
    public List<Notice> getAllNotice()
    {
        NoticeExample noticeExample =new NoticeExample();
        return noticeMapper.selectByExample(noticeExample);
    }

    @Override
    public int addNotice(String content)
    {
        Notice notice=new Notice();
        notice.setContent(content);
        Date date=new Date();
        Timestamp timeStamp = new Timestamp(date.getTime()); // 让日期时间转换为数据库中的timestamp类型
        notice.setTime(timeStamp);
        return noticeMapper.insertSelective(notice);
    }

    @Override
    public int deleteNotice(int noticeId)
    {
        return noticeMapper.deleteByPrimaryKey(noticeId);
    }
}
