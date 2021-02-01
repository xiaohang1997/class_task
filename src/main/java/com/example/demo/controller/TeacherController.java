package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Teacher)表控制层
 *
 * @author makejava
 * @since 2021-02-01 15:06:26
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;


}