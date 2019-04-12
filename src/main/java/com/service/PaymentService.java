package com.service;

import com.pojo.Payment;

public interface PaymentService {
    Payment getInfoById(int id);
    void creatPayment(Payment payment);
    void deletePayment(Payment payment);
    void changeStatus(int status);
}

