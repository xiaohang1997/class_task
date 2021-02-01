package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Subject)实体类
 *
 * @author makejava
 * @since 2021-02-01 10:59:04
 */
public class Subject implements Serializable {
    private static final long serialVersionUID = 985353138219334768L;

    private Integer id;

    private String name;

    private Integer isMajor;

    private Major major;

    private String time;


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

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}