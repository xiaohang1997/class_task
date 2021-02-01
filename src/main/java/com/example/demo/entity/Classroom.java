package com.example.demo.entity;

import java.io.Serializable;

/**
 * (Classroom)实体类
 *
 * @author makejava
 * @since 2021-02-01 10:59:01
 */
public class Classroom implements Serializable {
    private static final long serialVersionUID = -19391273784284820L;

    private Integer id;

    private String account;

    private String location;

    private String state;


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

}