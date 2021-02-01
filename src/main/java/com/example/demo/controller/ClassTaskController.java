package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.ClassTask;
import com.example.demo.service.ClassTaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @RequestMapping("createByMajor")
    public void createByMajor(Integer majorId){
        classTaskService.createByMajor(majorId);
    }

}