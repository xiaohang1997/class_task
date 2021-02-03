package com.example.demo.dao;

import com.example.demo.VO.ClassTaskVO;
import com.example.demo.entity.ClassTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ClassTask)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-01 15:06:17
 */
public interface ClassTaskDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClassTaskVO queryById(Integer id);



    /**
     * 通过实体作为筛选条件查询
     *
     * @param classTask 实例对象
     * @return 对象列表
     */
    List<ClassTaskVO> queryAll(ClassTask classTask);

    /**
     * 新增数据
     *
     * @param classTask 实例对象
     * @return 影响行数
     */
    int insert(ClassTask classTask);



    /**
     * 修改数据
     *
     * @param classTask 实例对象
     * @return 影响行数
     */
    int update(ClassTask classTask);

    /**
     * 通过主键删除数据
     *
     * @param  majorId
     * @return 影响行数
     */
    int deleteByMajorId(Integer majorId);

    int deleteAll();

}