package com.example.demo.VO;

import java.io.Serializable;

/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2021-02-01 15:06:26
 */
public class TeacherVO implements Serializable {
    private static final long serialVersionUID = 242724542609275916L;

    private Integer id;

    private String name;

    private SubjectVO subject;

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

    public SubjectVO getSubject() {
        return subject;
    }

    public void setSubject(SubjectVO subject) {
        this.subject = subject;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}