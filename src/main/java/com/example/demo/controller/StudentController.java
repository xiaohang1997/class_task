package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.VO.ClassroomVO;
import com.example.demo.VO.StudentVO;
import com.example.demo.entity.Classroom;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
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
 * (Student)表控制层
 *
 * @author makejava
 * @since 2021-02-01 15:06:23
 */
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    @RequestMapping("findAll")
    public ResultVO<StudentVO> findAll(int page, int limit){
        PageInfo pageInfo = studentService.findAll(page,limit, null);
        int total = (int)pageInfo.getTotal();
        ResultVO<StudentVO> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }

    @RequestMapping("deleteById")
    public JSONObject deleteById(Integer id){
        studentService.deleteById(id);
        return JsonResult.sendSuccess();
    }

    @RequestMapping("insert")
    public JSONObject insert(@RequestBody Student student){
        studentService.insert(student);
        return JsonResult.sendSuccess();
    }
}