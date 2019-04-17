package com.service;

import com.pojo.Point;
import com.pojo.User;

public interface PointService {
    void addPoint(Point point);
    int findPoint(User user);
}
