package com.example.homework.controller;

import com.example.homework.bean.User;
import com.example.homework.service.Studentservice;
import com.example.homework.service.TeacherService;
import com.example.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/user")
public class Usercontroller {
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    Studentservice studentservice;
    @PostMapping(value = "/login")
    public ModelAndView result(User user)
    {
        User user1= userService.login(user);
        if(user1==null){
            ModelAndView modelAndView=new ModelAndView("fail.html");
            return modelAndView;
        } else if (user1.getMd()==1) {
            ModelAndView modelAndView=new ModelAndView("admin.html");
            modelAndView.addObject("who",user1.getName());
            modelAndView.addObject("courses",userService.getcourse());
            modelAndView.addObject("teachers",userService.getuserbymod(2));
            modelAndView.addObject("students",userService.getuserbymod(3));
            return modelAndView;
        } else if (user1.getMd()==2) {
            ModelAndView modelAndView=new ModelAndView("teacher.html");
            modelAndView.addObject("courses",teacherService.getmycourse(user1.getName()));
            modelAndView.addObject("who",user1.getName());
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("student.html");
            modelAndView.addObject("courses",studentservice.getmycourse());
            modelAndView.addObject("who",user1.getName());
            modelAndView.addObject("account",user1.getAccount());
            return modelAndView;
        }
    }
}
