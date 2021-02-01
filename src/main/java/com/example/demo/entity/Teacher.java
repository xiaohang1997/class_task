package com.example.demo.entity;

import java.io.Serializable;

/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2021-02-01 15:06:26
 */
public class Teacher implements Serializable {
    private static final long serialVersionUID = 242724542609275916L;

    private Integer id;

    private String name;

    private Integer subjectId;


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

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}