package com.example.demo.entity;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2021-02-01 15:06:23
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -73744562776067836L;

    private Integer id;

    private String name;

    private Major major;

    private String password;


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

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}