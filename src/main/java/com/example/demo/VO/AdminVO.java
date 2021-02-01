package com.example.demo.VO;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2021-02-01 15:06:11
 */
public class AdminVO implements Serializable {
    private static final long serialVersionUID = -94706396581946990L;

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