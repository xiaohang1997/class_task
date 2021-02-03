package com.example.demo.service;

import com.example.demo.VO.MajorVO;
import com.example.demo.VO.TeacherVO;
import com.example.demo.dao.TeacherDao;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherService {

    @Resource
    private TeacherDao teacherDao;

    public PageInfo<TeacherVO> findAll(int page, int limit, Teacher teacher) {
        PageHelper.startPage(page, limit);
        List list = teacherDao.findAll(teacher);
        PageInfo result = new PageInfo(list);
        return result;
    }

    public boolean deleteById(Integer id) {
        return this.teacherDao.deleteById(id) > 0;
    }

    public int insert(Teacher teacher) {
        return teacherDao.insert(teacher);
    }

    public List login(Teacher teacher){
        return teacherDao.login(teacher);
    }
}
