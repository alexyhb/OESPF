package com.service;

import com.ResponseResult;
import com.alibaba.fastjson.JSONArray;
import com.pojo.Payment;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface PaymentService {
    JSONArray getInfoById(String username);
    JSONArray getInfoByStatus(@Param("username") String username, @Param("status") int status);
    ResponseResult creatPayment(@Param("username") String username, @Param("coursesId")int coursesId, @Param("price") BigDecimal price);
    ResponseResult changeStatus(@Param("username") String username, @Param("status") int status,@Param("id") int id);
}

