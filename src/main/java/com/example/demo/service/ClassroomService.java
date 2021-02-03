package com.example.demo.service;

import com.example.demo.VO.AdminVO;
import com.example.demo.VO.ClassroomVO;
import com.example.demo.dao.ClassroomDao;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Classroom;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassroomService {

    @Resource
    private ClassroomDao classroomDao;

    public PageInfo<ClassroomVO> findAll(int page, int limit, Classroom classroom) {
        PageHelper.startPage(page, limit);
        List list = classroomDao.findAll(classroom);
        PageInfo result = new PageInfo(list);
        return result;
    }

    public boolean deleteById(Integer id) {
        return this.classroomDao.deleteById(id) > 0;
    }

    public int insert(Classroom classroom) {
        return classroomDao.insert(classroom);
    }
}
