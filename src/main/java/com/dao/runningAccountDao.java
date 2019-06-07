package com.dao;

import com.pojo.runningAccount;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface runningAccountDao {
    boolean insertRA(@Param("username") String username, @Param("type") int type, @Param("totalAmount")BigDecimal totalAmount,@Param("remark") String remark);
    boolean deleteRA(int id);
    List<runningAccount> selectAll(int number);
    runningAccount selectOneByUser(String username);
}
