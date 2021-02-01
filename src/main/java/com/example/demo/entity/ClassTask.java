package com.example.demo.entity;

import java.io.Serializable;

/**
 * (ClassTask)实体类
 *
 * @author makejava
 * @since 2021-02-01 15:06:17
 */
public class ClassTask implements Serializable {
    private static final long serialVersionUID = 458573854512644819L;

    private Integer id;

    private Integer majorId;

    private Integer subjectId;

    private Integer teacherId;

    private Integer classroomId;

    private String time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}