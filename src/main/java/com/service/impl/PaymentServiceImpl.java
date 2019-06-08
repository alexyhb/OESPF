package com.service.impl;

import com.ResponseResult;
import com.alibaba.fastjson.JSONArray;
import com.dao.PaymentDao;
import com.pojo.Payment;
import com.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;


    @Override
    public JSONArray getInfoById(String username) {
        JSONArray json=new JSONArray();
        List<Payment> list=paymentDao.getInfoByUser(username);
        int j=list.size();
        for(int i=0;i<j;i++){
            json.add(list.toArray()[i]);
        }

        return json;
    }

    @Override
    public ResponseResult creatPayment(String username, int coursesId, BigDecimal price) {

        boolean flag=paymentDao.creatPayment(username,coursesId,price);
        ResponseResult responseResult=new ResponseResult(flag);
        return responseResult;
    }

    @Override
    public ResponseResult changeStatus(int status, int id) {
        boolean flag=paymentDao.changeStatus(status,id);
        ResponseResult responseResult=new ResponseResult(flag);
        return responseResult;
    }
}
