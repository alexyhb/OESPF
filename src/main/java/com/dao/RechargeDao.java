package com.dao;

import com.pojo.Recharge;

public interface RechargeDao {
    boolean addRecharge(Recharge recharge);
    boolean cancelRecharge(Recharge recharge);
    Recharge findInfoByOrder(int orderNumber);
}
