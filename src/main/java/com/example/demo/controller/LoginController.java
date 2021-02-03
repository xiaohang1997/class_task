package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.AdminService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import com.example.demo.utils.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LoginController {

    @Resource
    private AdminService adminService;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;

    private List list;

    @PostMapping("/loginUser")
    public JSONObject login(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        if (type.equals("admin")){
            Admin admin = new Admin();
            admin.setName(name);
            admin.setPassword(password);
            list = adminService.login(admin);
        }else if (type.equals("student")){
            Student student = new Student();
            student.setName(name);
            student.setPassword(password);
            list = studentService.login(student);
        }else if (type.equals("teacher")){
            Teacher teacher = new Teacher();
            teacher.setName(name);
            teacher.setPassword(password);
            list = teacherService.login(teacher);
        }

        if (list.isEmpty()){
            return JsonResult.sendError();
        }else {
            HttpSession session = request.getSession();
            //设置会话session对象有效期，默认10分钟
            session.setMaxInactiveInterval(10 * 60);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(10 * 60);
            response.addCookie(cookie);
            System.out.println(cookie.toString());
            session.setAttribute("user", list.get(0));
            JSONObject result = new JSONObject();
            result.put("msg", "success");
            result.put("type", type);
            return result;
        }
    }

    @RequestMapping("/getSession")
    public Object getSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        return session.getAttribute("user");
    }

    @RequestMapping("/logout")
    public JSONObject logOut(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return JsonResult.sendSuccess();
    }
}
