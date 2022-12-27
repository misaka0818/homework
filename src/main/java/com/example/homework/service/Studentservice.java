package com.example.homework.service;

import com.example.homework.bean.Course;
import com.example.homework.bean.Homework;
import com.example.homework.bean.Job;
import com.example.homework.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Studentservice {
    @Autowired
    UserMapper userMapper;
    public List<Course> getmycourse(){
        return userMapper.selectallcourse();
    }

    public List<Job> getmyjob(String cname) {
        return userMapper.selectmyjob(cname);
    }

    public void inserhomework(Homework homework) {
        userMapper.inserthomework(homework);
    }

    public List<Homework> gethomework(String account) {
        return userMapper.gethomework(account);
    }
}
