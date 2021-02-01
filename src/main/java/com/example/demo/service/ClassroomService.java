package com.example.demo.service;

import com.example.demo.dao.ClassroomDao;
import com.example.demo.entity.Classroom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Classroom)表服务实现类
 *
 * @author makejava
 * @since 2021-02-01 10:59:02
 */
@Service("classroomService")
public class ClassroomService {
    @Resource
    private ClassroomDao classroomDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    public Classroom queryById(Integer id) {
        return this.classroomDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */

    public List<Classroom> queryAllByLimit(int offset, int limit) {
        return this.classroomDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param classroom 实例对象
     * @return 实例对象
     */

    public Classroom insert(Classroom classroom) {
        this.classroomDao.insert(classroom);
        return classroom;
    }

    /**
     * 修改数据
     *
     * @param classroom 实例对象
     * @return 实例对象
     */

    public Classroom update(Classroom classroom) {
        this.classroomDao.update(classroom);
        return this.queryById(classroom.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */

    public boolean deleteById(Integer id) {
        return this.classroomDao.deleteById(id) > 0;
    }
}