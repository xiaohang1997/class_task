package com.example.demo.service;

import com.example.demo.dao.ClassTaskDao;
import com.example.demo.entity.ClassTask;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ClassTask)表服务实现类
 *
 * @author makejava
 * @since 2021-02-01 10:58:59
 */
@Service("classTaskService")
public class ClassTaskService {
    @Resource
    private ClassTaskDao classTaskDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    public ClassTask queryById(Integer id) {
        return this.classTaskDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */

    public List<ClassTask> queryAllByLimit(int offset, int limit) {
        return this.classTaskDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param classTask 实例对象
     * @return 实例对象
     */

    public ClassTask insert(ClassTask classTask) {
        this.classTaskDao.insert(classTask);
        return classTask;
    }

    /**
     * 修改数据
     *
     * @param classTask 实例对象
     * @return 实例对象
     */

    public ClassTask update(ClassTask classTask) {
        this.classTaskDao.update(classTask);
        return this.queryById(classTask.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */

    public boolean deleteById(Integer id) {
        return this.classTaskDao.deleteById(id) > 0;
    }
}