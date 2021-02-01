package com.example.demo.VO;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2021-02-01 15:06:23
 */
public class StudentVO implements Serializable {
    private static final long serialVersionUID = -73744562776067836L;

    private Integer id;

    private String name;

    private Integer majorId;


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

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

}