package com.example.demo.dao;

import com.example.demo.VO.AdminVO;
import com.example.demo.VO.StudentVO;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-01 15:06:23
 */
public interface StudentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StudentVO queryById(Integer id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param student 实例对象
     * @return 对象列表
     */
    List<StudentVO> queryAll(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int insert(Student student);



    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<StudentVO> findAll(Student student);

    List<StudentVO> login(Student student);
}