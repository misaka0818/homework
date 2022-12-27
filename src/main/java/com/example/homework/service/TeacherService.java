package com.example.homework.service;

import com.example.homework.bean.Course;
import com.example.homework.bean.Homework;
import com.example.homework.bean.Job;
import com.example.homework.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    UserMapper userMapper;
    public List<Course> getmycourse(String tname){
        return userMapper.selecybytname(tname);
    }

    public List<Job> getmyjob(String cname) {
        return userMapper.selectmyjob(cname);
    }

    public void insertjob(Job job) {
        userMapper.insertjob(job);
    }

    public void delete(String jname) {
        userMapper.deletjname(jname);
    }

    public List<Homework> gethomework(String cname) {
        return userMapper.getallhomework(cname);
    }

    public void givescore(String account, String jname,int score) {
        userMapper.givescore(account,jname,score);
    }
}
