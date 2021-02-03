package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.VO.ClassroomVO;
import com.example.demo.VO.TeacherVO;
import com.example.demo.entity.Classroom;
import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import com.example.demo.utils.JsonResult;
import com.example.demo.utils.ResultVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping("findAll")
    public ResultVO<TeacherVO> findAll(int page, int limit){
        PageInfo pageInfo = teacherService.findAll(page,limit, null);
        int total = (int)pageInfo.getTotal();
        ResultVO<TeacherVO> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }

    @RequestMapping("deleteById")
    public JSONObject deleteById(Integer id){
        teacherService.deleteById(id);
        return JsonResult.sendSuccess();
    }

    @RequestMapping("insert")
    public JSONObject insert(@RequestBody Teacher teacher){
        teacherService.insert(teacher);
        return JsonResult.sendSuccess();
    }
}