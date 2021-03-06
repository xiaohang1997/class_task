package com.example.demo.dao;

import com.example.demo.VO.ClassroomVO;
import com.example.demo.entity.Classroom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Classroom)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-01 15:06:19
 */
public interface ClassroomDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClassroomVO queryById(Integer id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param classroom 实例对象
     * @return 对象列表
     */
    List<ClassroomVO> queryAll(Classroom classroom);

    /**
     * 新增数据
     *
     * @param classroom 实例对象
     * @return 影响行数
     */
    int insert(Classroom classroom);


    /**
     * 修改数据
     *
     * @param classroom 实例对象
     * @return 影响行数
     */
    int update(Classroom classroom);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int updateStateById(Integer id, String state);

    int clearState();

    List<ClassroomVO> findAll(Classroom classroom);

    List<ClassroomVO> findByType(Integer type);
}