package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dao.PointDao;
import com.pojo.Point;
import com.pojo.User;
import com.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PointServiceImpl implements PointService {
    @Autowired
    PointDao pointDao;
    @Override
    public String addPoint(int userId,int rewordPoint ) {
        JSONObject json=new JSONObject();
        boolean flag =pointDao.addPoint(userId,rewordPoint);
        String msg;
        if(flag==true){
            msg="succsess";
        }else{
            msg="fail";
        }
        json.put("msg",msg);
        return json.toJSONString();
    }

    @Override
    public String losePoint(int userId,int point) {
        JSONObject json=new JSONObject();

        return json.toJSONString();
    }

    @Override
    public String findPoint(int userId) {
        JSONObject json=new JSONObject();

        return json.toJSONString();
    }
}
