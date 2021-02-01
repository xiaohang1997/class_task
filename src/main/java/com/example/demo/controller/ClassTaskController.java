package com.example.demo.controller;

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
 * @since 2021-02-01 10:59:01
 */
@RestController
@RequestMapping("classTask")
public class ClassTaskController {
    /**
     * 服务对象
     */
    @Resource
    private ClassTaskService classTaskService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ClassTask selectOne(Integer id) {
        return this.classTaskService.queryById(id);
    }

}