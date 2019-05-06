package com.service.impl;

import com.ResponseResult;
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
    public String addPoint(int userId,int rewardPoint ) {
        JSONObject json=new JSONObject();

        boolean flag =pointDao.addPoint(userId,rewardPoint);
        ResponseResult responseResult;
        responseResult=new ResponseResult(flag);
        json.put("msg",responseResult);
        return json.toJSONString();
    }

    @Override
    public String losePoint(int userId,int rewardPoint) {
        JSONObject json=new JSONObject();
        boolean flag=pointDao.losePoint(userId,rewardPoint);
        ResponseResult responseResult;
        responseResult=new ResponseResult(flag);
        json.put("msg",responseResult);
        return json.toJSONString();
    }

    @Override
    public String findPoint(int userId) {
        JSONObject json=new JSONObject();
        ResponseResult responseResult;
        String point=pointDao.getPointById(userId);
        if("".equals(point)){
            responseResult=new ResponseResult("no data");
        }else{
            responseResult=new ResponseResult("200","no data",point);
        }
        json.put("data",responseResult);
        return json.toJSONString();
    }
}
