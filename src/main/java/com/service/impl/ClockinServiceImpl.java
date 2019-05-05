package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dao.ClockinDao;
import com.service.ClockinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClockinServiceImpl implements ClockinService {
    @Autowired
    ClockinDao clockinDao;
    @Override
    public String getTotalById(int userId,int coursesId)
    {

        JSONObject json =new JSONObject();
        int nr =clockinDao.getTotalById(userId,coursesId);
        json.put("totalnumber",nr);
        return json.toJSONString() ;

    }

    @Override
    public String getCurrentById(int userId,int coursesId)
    {

        JSONObject json =new JSONObject();
        int nr =clockinDao.getCurrentById(userId,coursesId);
        json.put("currentNumber",nr);
        return json.toJSONString() ;
    }

    @Override
    public String clockin(int userId,int coursesId) {

        JSONObject json =new JSONObject();
        int nr =clockinDao.clockin(userId,coursesId);

        json.put("totalnumber",nr);
        return json.toJSONString() ;

    }
}
