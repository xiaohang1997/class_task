package com.example.demo.controller;

import com.example.demo.entity.Classroom;
import com.example.demo.service.ClassroomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Classroom)表控制层
 *
 * @author makejava
 * @since 2021-02-01 15:06:20
 */
@RestController
@RequestMapping("classroom")
public class ClassroomController {
    /**
     * 服务对象
     */
    @Resource
    private ClassroomService classroomService;



}