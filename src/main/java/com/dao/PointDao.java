package com.dao;

import com.pojo.Point;
import com.pojo.User;

public interface PointDao {

    void addPoint(Point point);
    int findPoint(User user);
}
