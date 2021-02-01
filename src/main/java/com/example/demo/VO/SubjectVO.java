package com.example.demo.VO;

import java.io.Serializable;
import java.util.Date;

/**
 * (Subject)实体类
 *
 * @author makejava
 * @since 2021-02-01 15:06:24
 */
public class SubjectVO implements Serializable {
    private static final long serialVersionUID = -20518662757620538L;

    private Integer id;

    private String name;

    private Integer isMajor;

    private Integer majorId;

    private Integer time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsMajor() {
        return isMajor;
    }

    public void setIsMajor(Integer isMajor) {
        this.isMajor = isMajor;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}