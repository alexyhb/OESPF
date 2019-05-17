package com.service;

import com.pojo.Recharge;

public interface RechargeService {
    String  addRecharge(Recharge recharge);
    String cancelRecharge(Recharge recharge);
    String findInfoByOrder(int orderNumber) throws Exception;

}
