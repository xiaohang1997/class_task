package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.VO.ClassroomVO;
import com.example.demo.VO.MajorVO;
import com.example.demo.entity.Classroom;
import com.example.demo.entity.Major;
import com.example.demo.service.MajorService;
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

    @RequestMapping("findAll")
    public ResultVO<MajorVO> findAll(int page, int limit){
        PageInfo pageInfo = majorService.findAll(page,limit, null);
        int total = (int)pageInfo.getTotal();
        ResultVO<MajorVO> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }

    @RequestMapping("deleteById")
    public JSONObject deleteById(Integer id){
        majorService.deleteById(id);
        return JsonResult.sendSuccess();
    }

    @RequestMapping("insert")
    public JSONObject insert(@RequestBody Major major){
        majorService.insert(major);
        return JsonResult.sendSuccess();
    }
}