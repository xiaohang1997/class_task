package com.example.demo.service;

import com.example.demo.VO.*;
import com.example.demo.dao.*;
import com.example.demo.entity.ClassTask;
import com.example.demo.entity.Classroom;
import com.example.demo.entity.Subject;
import com.example.demo.entity.Teacher;
import com.example.demo.utils.ResultClassTask;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class ClassTaskService {

    @Resource
    private MajorDao majorDao;

    @Resource
    private ClassTaskDao classTaskDao;

    @Resource
    private ClassroomDao classroomDao;

    @Resource
    private SubjectDao subjectDao;

    @Resource
    private TeacherDao teacherDao;

    private ClassTask classTask = new ClassTask();
    private ResultClassTask resultClassTask = new ResultClassTask();
//    private HashMap<String, > hashMap = new HashMap();
    private Integer majorId;
    private Integer subjectId;
    private Integer teacherId;
    private Integer classroomId;
    private String time;


    public void clearAll(){
        classroomDao.clearState();
        classTaskDao.deleteAll();
    }

    public ResultClassTask createAll(){
        classroomDao.clearState();
        classTaskDao.deleteAll();
        List<MajorVO> list = majorDao.findAll(null);
        for (MajorVO majorVO : list){
            resultClassTask = createByMajor(majorVO.getId());
            if (resultClassTask.getCode() == 400){
                return resultClassTask;
            }
        }
        return resultClassTask;
    }

    private ResultClassTask createByMajor(Integer majorId){
        if (majorId == null){
            resultClassTask.setCode(400);
            resultClassTask.setMsg("majorId参数为空");
            return resultClassTask;
        }
        classTaskDao.deleteByMajorId(majorId);
        this.majorId = majorId;
        Subject subject = new Subject();
        subject.setMajorId(majorId);
        List<SubjectVO> listSubjectVO = subjectDao.findAll(subject);
        for (SubjectVO subjectVO : listSubjectVO){
            Integer subjectTime = subjectVO.getTime();
            this.subjectId = subjectVO.getId();
            Integer subjectType = subjectVO.getIsMajor();
            TeacherVO teacherVO = this.findTeacherBySubjectId(subjectId);
            if (teacherVO == null){
                return resultClassTask;
            }
            this.teacherId = teacherVO.getId();
            for (int i=0; i < subjectTime; i++){
                boolean result = makeSureClassRoom(subjectType);
                if (!result){
                    classroomDao.clearState();
                    classTaskDao.deleteByMajorId(majorId);
                    return resultClassTask;
                }
            }
        }
        resultClassTask.setCode(200);
        resultClassTask.setMsg("成功");
        return resultClassTask;
    }

    //输入subjectType(0非专业课，大教室，1专业课，小教室)
    // 摇色子确定classroomId和time,并insert classTask
    public boolean makeSureClassRoom(Integer subjectType){
        int i = 0;
        while (i<100){
            i++;
            ClassroomVO classroomVO = this.findClassroom(subjectType);
            if (classroomVO == null){
                resultClassTask.setCode(400);
                resultClassTask.setMsg("不存在该类型教室");
                return false;
            }
            String time = this.getRandomTime();
            Integer classroomId = classroomVO.getId();
//            Integer classroomType = classroomVO.getType();
            Integer num = checkIfEmpty(time, classroomId);
            if (num == 0){
                this.classroomId = classroomId;
                this.time = time;
                break;
            }
        }
        if (i>100){
            resultClassTask.setCode(400);
            resultClassTask.setMsg("教室数量太少");
            return false;
        }
        this.classTask.setMajorId(this.majorId);
        this.classTask.setSubjectId(this.subjectId);
        this.classTask.setTeacherId(this.teacherId);
        this.classTask.setClassroomId(this.classroomId);
        this.classTask.setTime(this.time);
        classTaskDao.insert(this.classTask);
        return true;
    }


    //输入subjectId 随即返回此学科老师
    private TeacherVO findTeacherBySubjectId(Integer subjectId){
        Random random = new Random();
        Teacher teacher = new Teacher();
        teacher.setSubjectId(subjectId);
        List<TeacherVO> listTeacher = teacherDao.findAll(teacher);
        if (listTeacher.size() == 0){
            resultClassTask.setCode(400);
            resultClassTask.setMsg("存在课程没有任课教师");
            return null;
        }
        Integer i = random.nextInt(listTeacher.size());
        TeacherVO teacherVO = listTeacher.get(i);
        return teacherVO;
    }

    //输入科目类型，获得随机一个大教室或者小教室
    private ClassroomVO findClassroom(Integer subjectType){
        switch(subjectType){
            //专业课，小教室
            case 1 :
                List<ClassroomVO> classroomVOList = classroomDao.findByType(1);
                Random random = new Random();
                if (classroomVOList.size()==0){
                    return null;
                }
                Integer i = random.nextInt(classroomVOList.size());
                return classroomVOList.get(i);
            //非专业课，大教室
            case 0 :
                List<ClassroomVO> classroomVOList2 = classroomDao.findByType(0);
                Random random2 = new Random();
                if (classroomVOList2.size()==0){
                    return null;
                }
                Integer i2 = random2.nextInt(classroomVOList2.size());
                return classroomVOList2.get(i2);
        }
        return null;
    }

    //生成随机时间，如12(周一第二节),1-5周一到周五，1-4一到四节课
    private String getRandomTime(){
        Random random = new Random();
        Integer firstNum = random.nextInt(5) + 1;
        String one = firstNum.toString();
        Integer secondNum = random.nextInt(4) + 1;
        String two = secondNum.toString();
        return one + two;
    }

    //输入时间段如 12, ClassRoom id，教室type(0大1小)判断是否空闲 教室type=科目type
    //0未占用，1已占用，2没进逻辑
    private Integer checkIfEmpty(String time, Integer classroomId){
        ClassroomVO classroomVO = classroomDao.queryById(classroomId);
        if (classroomVO.getState().isEmpty()){
            classroomDao.updateStateById(classroomId, time);
            return 0;
        }
        String state = classroomVO.getState();
        List<String> list = Arrays.asList(state.split(","));       //用,分隔
        for (String str : list){
            if (str.equals(time)){
                //已被占用
                return 1;
            }
        }
        //未被占用,insert classroom
        classroomDao.updateStateById(classroomId, state + "," + time);
        return 0;
//        switch (type){
//            //小教室
//            case 1:
//                ClassroomVO classroomVO = classroomDao.queryById(classroomId);
//                if (classroomVO.getState().isEmpty()){
//                    classroomDao.updateStateById(classroomId, time);
//                    return 0;
//                }
//                String state = classroomVO.getState();
//                List<String> list = Arrays.asList(state.split(","));       //用,分隔
//                for (String str : list){
//                    if (str.equals(time)){
//                        //已被占用
//                        return 1;
//                    }
//                }
//                //未被占用,insert classroom
//                classroomDao.updateStateById(classroomId, state + "," + time);
//                return 0;
//
//            //大教室
//            case 0:
//                int i = 0;
//                ClassroomVO classroomVO2 = classroomDao.queryById(classroomId);
//                if (classroomVO2.getState().isEmpty()){
//                    classroomDao.updateStateById(classroomId, time);
//                    return 0;
//                }
//                String state2 = classroomVO2.getState();
//                List<String> list2 = Arrays.asList(state2.split(","));       //用,分隔
//                for (String str : list2){
//                    if (str.equals(time)){
//                        i += 1;
//                    }
//                    if (i > 1){
//                        return 1;
//                    }
//                }
//                //未被占用 insert classroom
//                classroomDao.updateStateById(classroomId, state2 + "," + time);
//                return 0;
//        }
    }



}
