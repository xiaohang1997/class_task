package com.example.demo.service;

import com.example.demo.VO.ClassroomVO;
import com.example.demo.VO.MajorVO;
import com.example.demo.dao.MajorDao;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Major;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MajorService {

    @Resource
    private MajorDao majorDao;

    public PageInfo<MajorVO> findAll(int page, int limit, Major major) {
        PageHelper.startPage(page, limit);
        List list = majorDao.findAll(major);
        PageInfo result = new PageInfo(list);
        return result;
    }

    public boolean deleteById(Integer id) {
        return this.majorDao.deleteById(id) > 0;
    }

    public int insert(Major major) {
        return majorDao.insert(major);
    }
}
