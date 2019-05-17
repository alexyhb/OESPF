package com.service.impl;

import com.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import com.dao.RechargeDao;
import com.pojo.Recharge;
import com.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RechargeServiceImpl implements RechargeService {
    @Autowired
    RechargeDao rechargeDao;
    @Override
    public String addRecharge(Recharge recharge) {
        JSONObject json=new JSONObject();
        return json.toJSONString();
    }

    @Override
    public String cancelRecharge(Recharge recharge) {
        JSONObject json=new JSONObject();
        return json.toJSONString();
    }

    /**
     *
     * @param orderNumber
     * @return
     * @throws Exception
     */
    @Override
    public String findInfoByOrder(int orderNumber) throws Exception {
        JSONObject json=new JSONObject();
        Recharge info=rechargeDao.findInfoByOrder(orderNumber);
        try {
            if(info.equals(null)){
                ResponseResult responseResult=new ResponseResult("no data");
                json.put("data",responseResult);
                return  json.toJSONString();
            }
        }catch (Exception e){

            throw new Exception(e.getMessage());

        }

        JSONObject infoJson=info.infoToString(info);
        ResponseResult responseResult=new ResponseResult("200","sucusess",infoJson);
        json.put("",responseResult);
        return json.toJSONString();
    }


}
