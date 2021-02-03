package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.VO.ClassroomVO;
import com.example.demo.VO.SubjectVO;
import com.example.demo.entity.Classroom;
import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;
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

    @RequestMapping("findAll")
    public ResultVO<SubjectVO> findAll(int page, int limit){
        PageInfo pageInfo = subjectService.findAll(page,limit, null);
        int total = (int)pageInfo.getTotal();
        ResultVO<SubjectVO> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }

    @RequestMapping("deleteById")
    public JSONObject deleteById(Integer id){
        subjectService.deleteById(id);
        return JsonResult.sendSuccess();
    }

    @RequestMapping("insert")
    public JSONObject insert(@RequestBody Subject subject){
        subjectService.insert(subject);
        return JsonResult.sendSuccess();
    }
}