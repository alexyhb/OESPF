package com.service;

import com.ResponseResult;
import com.pojo.Recharge;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface RechargeService {
    ResponseResult addRecharge(@Param("username") String username, @Param("addBalance")BigDecimal addBalance);
    ResponseResult cancelRecharge(Recharge recharge);
    String findInfoByOrder(int orderNumber) throws Exception;

}
