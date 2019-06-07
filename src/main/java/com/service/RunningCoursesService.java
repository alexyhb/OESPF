package com.service;

import com.ResponseResult;
import com.alibaba.fastjson.JSONObject;

public interface RunningCoursesService {
    ResponseResult joinIn(String username,int coursesId);
    JSONObject queryInfo(String username,int coursesId);
    ResponseResult updateCnumber(String username,int coursesId);

}
