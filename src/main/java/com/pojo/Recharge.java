package com.pojo;

import com.alibaba.fastjson.JSONObject;

public class Recharge {
    private int id;
    private int userId;
    private int toUpBalance;
    private int status;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    private int orderNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getToUpBalance() {
        return toUpBalance;
    }

    public void setToUpBalance(int toUpBalance) {
        this.toUpBalance = toUpBalance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public JSONObject infoToString(Recharge recharge){
        JSONObject json=new JSONObject();
        json.put("order_number",recharge.getOrderNumber());
        json.put("Status",recharge.getStatus());
        json.put("to_up_balance",recharge.getToUpBalance());
        json.put("User_id",recharge.getUserId());
        return json;
    }
}
