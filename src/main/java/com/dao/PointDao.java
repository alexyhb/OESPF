package com.dao;

import com.pojo.Point;
import com.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface PointDao {
    Point getPointById(int userId);
    boolean  addPoint(@Param("userId") int userId, @Param("rewardPoint") int rewardPoint);
    boolean  losePoint(@Param("userId") int userId, @Param("rewardPoint") int rewardPoint);
}
