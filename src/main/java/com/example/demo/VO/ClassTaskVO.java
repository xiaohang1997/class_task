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

    private MajorVO major;

    private SubjectVO subject;

    private TeacherVO teacher;

    private ClassroomVO classroom;

    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MajorVO getMajor() {
        return major;
    }

    public void setMajor(MajorVO major) {
        this.major = major;
    }

    public SubjectVO getSubject() {
        return subject;
    }

    public void setSubject(SubjectVO subject) {
        this.subject = subject;
    }

    public TeacherVO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherVO teacher) {
        this.teacher = teacher;
    }

    public ClassroomVO getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomVO classroom) {
        this.classroom = classroom;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}