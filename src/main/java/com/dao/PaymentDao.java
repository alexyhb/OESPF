package com.dao;

import com.pojo.Payment;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentDao {
    List<Payment> getInfoByUser(String username);
    Payment getInfoById(int id);
    boolean creatPayment(@Param("username") String username, @Param("coursesId")int coursesId, @Param("price")BigDecimal price);
    boolean changeStatus(@Param("status") int status,@Param("id") int id);



//    private int id;
//    private int userId;
//    private int coursesId;
//    private float price;
//    private float realPrice;
//    private int status;
}
