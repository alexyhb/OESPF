package com.service;

import com.pojo.Point;
import com.pojo.User;

public interface PointService {
    String addPoint(int userId,int rewardPoint);
    String losePoint(int userId,int rewardPoint);
    String findPoint(int userId);

}
