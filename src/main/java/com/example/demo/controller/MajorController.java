package com.example.demo.controller;

import com.example.demo.entity.Major;
import com.example.demo.service.MajorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Major)表控制层
 *
 * @author makejava
 * @since 2021-02-01 15:06:22
 */
@RestController
@RequestMapping("major")
public class MajorController {
    /**
     * 服务对象
     */
    @Resource
    private MajorService majorService;



}