package com.service.impl;

import com.ResponseResult;
import com.alibaba.fastjson.JSONArray;
import com.dao.PaymentDao;
import com.dao.RunningCoursesDao;
import com.dao.UserDao;
import com.pojo.Payment;
import com.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;
    @Autowired
    UserDao userDao;
    @Autowired
    RunningCoursesDao runningCoursesDao;



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
    public JSONArray getInfoByStatus(String username,int status) {
        JSONArray json=new JSONArray();
        List<Payment> list=paymentDao.getInfoByStatus(username,status);
        int j=list.size();
        for(int i=0;i<j;i++){
            json.add(list.toArray()[i]);
        }

        return json;
    }

    @Override
    public ResponseResult creatPayment(String username, int coursesId, BigDecimal price) {
        List<Payment> list=paymentDao.queryPayment(username,coursesId);
        int j=list.size();


        if(j>0){

            ResponseResult responseResult=new ResponseResult("请勿重复提交订单");
            return responseResult;
        }else {
            boolean flag=paymentDao.creatPayment(username,coursesId,price);
            ResponseResult responseResult=new ResponseResult(flag);
            return responseResult;
        }

    }


    @Override

    public ResponseResult changeStatus(String username,int status, int id) {
        if(status==4){
            boolean flag=paymentDao.changeStatus(status,id);
            ResponseResult re=new ResponseResult(flag);
            return  re;
        }
        BigDecimal balance=userDao.getBalance(username);
        Payment payment=paymentDao.getInfoById(id);
        System.out.println(balance);
        BigDecimal price=payment.getPrice();
        if (balance.floatValue()< price.floatValue()){
            ResponseResult re=new ResponseResult("您的余额不足请充值");

            return re;
        }else {
            boolean flag1=userDao.deBalance(username,price);
            if(flag1==true){
                boolean flag=paymentDao.changeStatus(status,id);
                if (flag==true){
                    boolean flag2=runningCoursesDao.joinIn(username,payment.getCoursesId());
                    ResponseResult responseResult=new ResponseResult(flag2);

                    return responseResult;
                }else {
                    throw new RuntimeException();
                }

            }else{
                ResponseResult responseResult=new ResponseResult(flag1);
                return responseResult;
            }

        }
    }
}
