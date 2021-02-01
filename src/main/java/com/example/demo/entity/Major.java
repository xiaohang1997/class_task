package com.example.demo.entity;

import java.io.Serializable;

/**
 * (Major)实体类
 *
 * @author makejava
 * @since 2021-02-01 15:06:21
 */
public class Major implements Serializable {
    private static final long serialVersionUID = -91049642174931113L;

    private Integer id;

    private String name;


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

}