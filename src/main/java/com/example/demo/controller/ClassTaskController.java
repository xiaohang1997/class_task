package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.VO.MajorVO;
import com.example.demo.entity.ClassTask;
import com.example.demo.service.ClassTaskService;
import com.example.demo.service.MajorService;
import com.example.demo.utils.ResultClassTask;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ClassTask)表控制层
 *
 * @author makejava
 * @since 2021-02-01 15:06:18
 */
@RestController
@RequestMapping("classTask")
public class ClassTaskController {
    /**
     * 服务对象
     */
    @Resource
    private ClassTaskService classTaskService;


    @RequestMapping("createAll")
    public JSONObject createAll(){
        JSONObject result = new JSONObject();
        ResultClassTask resultClassTask = classTaskService.createAll();
        String msg = resultClassTask.getMsg();
        if(resultClassTask.getCode()==400){
            classTaskService.clearAll();
            result.put("code",400);
            result.put("msg",msg);
            return result;
        }
        else {
            result.put("code", 200);
            result.put("msg","success");
            return result;
        }
    }
}