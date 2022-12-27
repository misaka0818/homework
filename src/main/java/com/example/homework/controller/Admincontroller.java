package com.example.homework.controller;

import ch.qos.logback.core.model.Model;
import com.example.homework.bean.Course;
import com.example.homework.bean.User;
import com.example.homework.service.AdminService;
import com.example.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/admin")
public class Admincontroller {
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @RequestMapping("/deletecourse")
    public ModelAndView deletecourse(String cname,String who){
        adminService.deletecourse(cname);
        ModelAndView modelAndView=new ModelAndView("admin.html");
        modelAndView.addObject("who",who);
        modelAndView.addObject("courses",userService.getcourse());
        modelAndView.addObject("teachers",userService.getuserbymod(2));
        modelAndView.addObject("students",userService.getuserbymod(3));
        return modelAndView;
    }
    @PostMapping("/insertcourse")
    public ModelAndView insertcourse(Course course,String who){
        adminService.insertcourse(course);
        ModelAndView modelAndView=new ModelAndView("admin.html");
        modelAndView.addObject("who",who);
        modelAndView.addObject("courses",userService.getcourse());
        modelAndView.addObject("teachers",userService.getuserbymod(2));
        modelAndView.addObject("students",userService.getuserbymod(3));
        return modelAndView;
    }
    @PostMapping("/insertuser")
    public ModelAndView insertstudents(User user,String who,String md){
        if(Objects.equals(md, "2"))
            user.setMod(2);
        else
            user.setMod(3);
         adminService.insertuser(user);
        ModelAndView modelAndView=new ModelAndView("admin.html");
        modelAndView.addObject("who",who);
        modelAndView.addObject("courses",userService.getcourse());
        modelAndView.addObject("teachers",userService.getuserbymod(2));
        modelAndView.addObject("students",userService.getuserbymod(3));
        return modelAndView;
    }
    @RequestMapping("/deleteuser")
    public ModelAndView deleteuser(String account,String who){
        adminService.deleteuser(account);
        ModelAndView modelAndView=new ModelAndView("admin.html");
        modelAndView.addObject("who",who);
        modelAndView.addObject("courses",userService.getcourse());
        modelAndView.addObject("teachers",userService.getuserbymod(2));
        modelAndView.addObject("students",userService.getuserbymod(3));
        return modelAndView;
    }
}
