package com.example.demo.entity;

import java.io.Serializable;

/**
 * (Major)实体类
 *
 * @author makejava
 * @since 2021-02-01 10:59:02
 */
public class Major implements Serializable {
    private static final long serialVersionUID = -79610499442525756L;

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