package com.example.demo.VO;

import com.example.demo.entity.Classroom;
import com.example.demo.entity.Major;
import com.example.demo.entity.Subject;
import com.example.demo.entity.Teacher;

import java.io.Serializable;

/**
 * (ClassTask)实体类
 *
 * @author makejava
 * @since 2021-02-01 15:06:17
 */
public class ClassTaskVO implements Serializable {
    private static final long serialVersionUID = 458573854512644819L;

    private Integer id;

    private Major major;

    private Subject subject;

    private Teacher teacher;

    private Classroom classroom;

    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}