package com.example.demo.dao;

import com.example.demo.VO.TeacherVO;
import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Teacher)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-01 15:06:26
 */
public interface TeacherDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TeacherVO queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TeacherVO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param teacher 实例对象
     * @return 对象列表
     */
    List<TeacherVO> queryAll(Teacher teacher);

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int insert(Teacher teacher);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Teacher> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Teacher> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Teacher> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Teacher> entities);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}