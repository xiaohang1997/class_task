package com.example.demo.entity;

import java.io.Serializable;

/**
 * (Classroom)实体类
 *
 * @author makejava
 * @since 2021-02-01 15:06:19
 */
public class Classroom implements Serializable {
    private static final long serialVersionUID = -42779688183565114L;

    private Integer id;

    private String account;

    private String location;

    private String state;

    private Integer type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}