package com.dao;

import com.pojo.Payment;

public interface PaymentDao {

    Payment getInfoById(int id);
    void creatPayment(Payment payment);
    void deletePayment(Payment payment);
    void changeStatus(int status);



//    private int id;
//    private int userId;
//    private int coursesId;
//    private float price;
//    private float realPrice;
//    private int status;
}
