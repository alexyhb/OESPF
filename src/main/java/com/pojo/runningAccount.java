package com.pojo;

import java.math.BigDecimal;

public class runningAccount {
    private int id;
    private String username;
    private int type;
    private BigDecimal totalAmonut;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public BigDecimal getTotalAmonut() {
        return totalAmonut;
    }

    public void setTotalAmonut(BigDecimal totalAmonut) {
        this.totalAmonut = totalAmonut;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
