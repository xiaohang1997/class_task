package com.example.demo.service;

import com.example.demo.VO.AdminVO;
import com.example.demo.dao.AdminDao;
import com.example.demo.entity.Admin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminDao adminDao;

    public PageInfo<AdminVO> findAll(int page, int limit, Admin admin) {
        PageHelper.startPage(page, limit);
        List list = adminDao.findAll(admin);
        PageInfo result = new PageInfo(list);
        return result;
    }

    public boolean deleteById(Integer id) {
        return this.adminDao.deleteById(id) > 0;
    }

    public int insert(Admin admin) {
       return adminDao.insert(admin);
    }

    public List login(Admin admin){
        return adminDao.login(admin);
    }
}
