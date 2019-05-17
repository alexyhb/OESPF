package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.impl.RechargeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Recharge")
public class RechargeController {
    @Autowired
    RechargeServiceImpl rechargeService;
    @ResponseBody
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    public String findInfo(@RequestParam("orderNumber")int orderNumber){
        JSONObject json =new JSONObject();
        try{
            String data=rechargeService.findInfoByOrder(orderNumber);
            json.put("data",data);
            return json.toJSONString();
        }catch (Exception e){
            json.put("data","");
            return json.toJSONString();
        }
    }

}
