package com.service;

import com.ResponseResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface CoursesUrlService {
    JSONArray  getUrlList(int coursesId);
    JSONObject getUrlbyId(int coursesId,int currentNumber);
    ResponseResult addLecture(int coursesId,int totalNumber,int currentNumber,String url,String lectureName);
    ResponseResult deleletLecture(int coursesId,int currentNumber);
    ResponseResult setLecture(int coursesId,int currentNumber,String url,String lectureName);


}
