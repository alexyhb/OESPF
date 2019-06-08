package com.service.impl;

import com.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import com.dao.RunningCoursesDao;
import com.pojo.RunningCourses;
import com.service.RunningCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunningCoursesServiceImpl implements RunningCoursesService {
    @Autowired
    RunningCoursesDao runningCoursesDao;


    @Override
    public ResponseResult joinIn(String username, int coursesId) {
        RunningCourses runningCourses = runningCoursesDao.queryInfo(username, coursesId);
        if (username == runningCourses.getUsername() && coursesId == runningCourses.getCoursesId()) {
            ResponseResult responseResult = new ResponseResult("您已参加本课程请勿重复操作");
        } else {
            boolean flag = runningCoursesDao.joinIn(username, coursesId);
            ResponseResult responseResult = new ResponseResult(flag);
            return responseResult;
        }
        return null;
    }

    @Override
    public JSONObject queryInfo(String username, int coursesId) {
        JSONObject json=new JSONObject();
        RunningCourses runningCourses=runningCoursesDao.queryInfo(username,coursesId);
        if(runningCourses!=null){
            json.put("code",200);
            json.put("data",runningCourses);
        }else{
            json.put("code",400);
            json.put("data","你没有购买本课程，请先购买");
        }
        return json;
    }

    @Override
    public ResponseResult updateCnumber(String username, int coursesId) {
        boolean flag=runningCoursesDao.updateCnumber(username,coursesId);
        ResponseResult responseResult=new ResponseResult(flag);
        return responseResult;
    }
}
