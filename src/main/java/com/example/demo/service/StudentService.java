package com.example.demo.service;

import com.example.demo.VO.MajorVO;
import com.example.demo.VO.StudentVO;
import com.example.demo.dao.MajorDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Resource
    private StudentDao studentDao;

    public PageInfo<StudentVO> findAll(int page, int limit, Student student) {
        PageHelper.startPage(page, limit);
        List<StudentVO> list = studentDao.findAll(student);
        PageInfo result = new PageInfo(list);
        return result;
    }

    public boolean deleteById(Integer id) {
        return this.studentDao.deleteById(id) > 0;
    }

    public int insert(Student student) {
        return studentDao.insert(student);
    }

    public List login(Student student){
        return studentDao.login(student);
    }
}
