package com.example.demo.service;

import com.example.demo.VO.MajorVO;
import com.example.demo.VO.SubjectVO;
import com.example.demo.dao.SubjectDao;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Subject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectService {

    @Resource
    private SubjectDao subjectDao;

    public PageInfo<SubjectVO> findAll(int page, int limit, Subject subject) {
        PageHelper.startPage(page, limit);
        List list = subjectDao.findAll(subject);
        PageInfo result = new PageInfo(list);
        return result;
    }

    public boolean deleteById(Integer id) {
        return this.subjectDao.deleteById(id) > 0;
    }

    public int insert(Subject subject) {
        return subjectDao.insert(subject);
    }
}
