package com.controller;

import com.ResponseResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.service.impl.PaymentServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    PaymentServiceImpl paymentService;

    @ResponseBody
    @RequestMapping(value = "/queryList",method = RequestMethod.POST)
    public String  queryList(@RequestParam("username") String username){
        JSONArray json=paymentService.getInfoById(username);

        return json.toJSONString();

    }
    @ResponseBody
    @RequestMapping(value = "/addPayment",method = RequestMethod.POST)
    public String addPayment(@RequestParam("username") String username, @RequestParam("coursesId")int coursesId, @RequestParam("price") BigDecimal price){
        JSONObject json=new JSONObject();
        ResponseResult re=paymentService.creatPayment(username,coursesId,price);
        json.put("data",re);
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/pay",method=  RequestMethod.POST)
    public String pay(@RequestParam("id") int id){
        JSONObject json=new JSONObject();
        ResponseResult re=paymentService.changeStatus(2,id);
        json.put("data",re);
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value="/cancle", method=  RequestMethod.POST)
    public String cancle(@RequestParam("id") int id){
        JSONObject json=new JSONObject();
        ResponseResult re=paymentService.changeStatus(4,id);
        json.put("data",re);
        return json.toJSONString();
    }
}
