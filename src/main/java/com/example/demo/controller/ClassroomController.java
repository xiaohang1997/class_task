package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.VO.AdminVO;
import com.example.demo.VO.ClassroomVO;
import com.example.demo.entity.Classroom;
import com.example.demo.service.ClassroomService;
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

    @RequestMapping("findAll")
    public ResultVO<ClassroomVO> findAll(int page, int limit){
        PageInfo pageInfo = classroomService.findAll(page,limit, null);
        int total = (int)pageInfo.getTotal();
        ResultVO<ClassroomVO> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }

    @RequestMapping("deleteById")
    public JSONObject deleteById(Integer id){
        classroomService.deleteById(id);
        return JsonResult.sendSuccess();
    }

    @RequestMapping("insert")
    public JSONObject insert(@RequestBody Classroom classroom){
        classroomService.insert(classroom);
        return JsonResult.sendSuccess();
    }

}