package com.example.demo.controller;

import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Subject)表控制层
 *
 * @author makejava
 * @since 2021-02-01 15:06:25
 */
@RestController
@RequestMapping("subject")
public class SubjectController {
    /**
     * 服务对象
     */
    @Resource
    private SubjectService subjectService;



}