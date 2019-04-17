package com.pojo;

public class Recharge {
    private int id;
    private int user_id;
    private int toUpBalance;
    private int status;
    private int orderNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
}
