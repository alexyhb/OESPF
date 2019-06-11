package com.dao;

import com.pojo.Recharge;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface RechargeDao {
    boolean addRecharge(@Param("username") String username, @Param("addBalance") BigDecimal addBalance);
    boolean cancelRecharge(Recharge recharge);
    Recharge findInfoByOrder(int orderNumber);
}
