package com.controller;

import com.ResponseResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.service.impl.CoursesUrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "CoursesURL")
public class CoursesUrlController {
    @Autowired
    public CoursesUrlServiceImpl coursesUrlService;



    @ResponseBody
    @RequestMapping(value = "/getList" ,method = RequestMethod.POST)
    public String getList(@RequestParam("coursesId")int coursesId){
        JSONArray json=coursesUrlService.getUrlList(coursesId);
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/getById" ,method = RequestMethod.POST)
    public String getById(@RequestParam("coursesId")int coursesId,@RequestParam("currentNumber")int currentNumber){
        JSONObject json=coursesUrlService.getUrlbyId(coursesId,currentNumber);
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/addLecture" ,method = RequestMethod.POST)
    public String addLecture(@RequestParam("coursesId")int coursesId, @RequestParam("totalNumber")int totalNumber, @RequestParam("currentNumber")int currentNumber, @RequestParam("url")String url, @RequestParam("lecture_name") String lectureName){
        JSONObject json=new JSONObject();
        ResponseResult responseResult=coursesUrlService.addLecture(coursesId,totalNumber,currentNumber,url,lectureName);
        json.put("data",responseResult);
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping(value = "/delectLecture" ,method = RequestMethod.POST)
    public String delectLecture(@RequestParam("coursesId")int coursesId,@RequestParam("currentNumber")int currentNumber){
        JSONObject json=new JSONObject();
        ResponseResult responseResult=coursesUrlService.deleletLecture(coursesId,currentNumber);
        json.put("data",responseResult);
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping(value = "/setLecture" ,method = RequestMethod.POST)
    public String setLecture(@RequestParam("coursesId")int coursesId,@RequestParam("currentNumber")int currentNumber,@RequestParam("url")String url,@RequestParam("lecture_name") String lectureName){
        JSONObject json=new JSONObject();
        ResponseResult responseResult=coursesUrlService.setLecture(coursesId,currentNumber,url,lectureName);
        json.put("data",responseResult);
        return json.toJSONString();
    }

}
