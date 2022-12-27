package com.example.homework.service;

import com.example.homework.bean.Course;
import com.example.homework.bean.User;
import com.example.homework.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User login(User user){
        User user1=userMapper.selectbyaccount(user.getAccount());
        if(user1==null)
            return null;
        else{
            if(user1.getPassword().equals(user.getPassword())){
                return user1;
            }
            else
                return null;
        }
    }
    public List<Course> getcourse(){
        List<Course> courses=userMapper.selectallcourse();
        return courses;
    }
    public List<User> getuserbymod(int md){
        List<User> users=userMapper.selectbymod(md);
        return  users;
    }
}
