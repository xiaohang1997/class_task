package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.VO.AdminVO;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import com.example.demo.utils.JsonResult;
import com.example.demo.utils.ResultVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2021-02-01 15:06:14
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    @RequestMapping("findAll")
    public ResultVO<AdminVO> findAll(int page, int limit){
        PageInfo pageInfo = adminService.findAll(page,limit,null);
        int total = (int)pageInfo.getTotal();
        ResultVO<AdminVO> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }

    @RequestMapping("deleteById")
    public JSONObject deleteById(Integer id){
        adminService.deleteById(id);
        return JsonResult.sendSuccess();
    }

    @RequestMapping("insert")
    public JSONObject insert(@RequestBody Admin admin){
        adminService.insert(admin);
        return JsonResult.sendSuccess();
    }


}