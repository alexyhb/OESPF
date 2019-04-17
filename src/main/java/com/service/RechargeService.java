package com.service;

import com.pojo.Recharge;

public interface RechargeService {
    void addRecharge(Recharge recharge);
    void cancelRecharge(Recharge recharge);
    void findInfoByOrder(Recharge recharge);

}
