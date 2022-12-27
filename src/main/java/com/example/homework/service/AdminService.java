package com.example.homework.service;

import com.example.homework.bean.Course;
import com.example.homework.bean.User;
import com.example.homework.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    UserMapper userMapper;
    public List<Course> getcourse(){
        List<Course> courses=userMapper.selectallcourse();
        return courses;
    }
    public void deletecourse(String cname){
        userMapper.deletecourse(cname);
    }
    public void insertcourse(Course course){
        userMapper.insertcourse(course);
    }
    public void insertuser(User user){
        userMapper.insertuser(user);
    }
    public void deleteuser(String account){
        userMapper.deleteuser(account);
    }
}
