package com.dao;

import com.pojo.Recharge;

public interface RechargeDao {
    void addRecharge(Recharge recharge);
    void cancelRecharge(Recharge recharge);
    Recharge findInfoByOrder(int order_number);
}
