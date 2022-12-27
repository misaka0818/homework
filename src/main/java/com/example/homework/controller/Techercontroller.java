package com.example.homework.controller;

import com.example.homework.bean.Job;
import com.example.homework.service.TeacherService;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/teacher")
public class Techercontroller {
    private String fileLocation="static/files";
    @Autowired
    TeacherService teacherService;
    @RequestMapping("/course")
    public ModelAndView getmyjob(String cname ,String who) {
        ModelAndView modelAndView=new ModelAndView("course.html");
        modelAndView.addObject("who",who);
        modelAndView.addObject("jobs",teacherService.getmyjob(cname));
        modelAndView.addObject("homeworks",teacherService.gethomework(cname));
        return modelAndView;
    }
    @PostMapping("/insertjob")
    public ModelAndView insertjob(Job job,String who,String cname){
        ModelAndView modelAndView=new ModelAndView("course.html");
        teacherService.insertjob(job);
        modelAndView.addObject("who",who);
        modelAndView.addObject("jobs",teacherService.getmyjob(cname));
        modelAndView.addObject("homeworks",teacherService.gethomework(cname));
        return modelAndView;
    }
    @RequestMapping("/deletejob")
    public ModelAndView deletejob(String who,String cname,String jname){
        ModelAndView modelAndView=new ModelAndView("course.html");
        teacherService.delete(jname);
        modelAndView.addObject("who",who);
        modelAndView.addObject("jobs",teacherService.getmyjob(cname));
        modelAndView.addObject("homeworks",teacherService.gethomework(cname));
        return modelAndView;
    }
    @PostMapping("/givescore")
    public ModelAndView givescore(String who,String cname,String account,String jname,String score){
        ModelAndView modelAndView=new ModelAndView("course.html");
        modelAndView.addObject("who",who);
        modelAndView.addObject("jobs",teacherService.getmyjob(cname));
        int score1=Integer.parseInt(score);
        teacherService.givescore(account,jname,score1);
        modelAndView.addObject("homeworks",teacherService.gethomework(cname));
        return modelAndView;
    }
    @GetMapping("/download")
    public void download(String fileName, HttpServletResponse response) throws IOException {
        // 获得待下载文件所在文件夹的绝对路径
        String realPath = ResourceUtils.getURL("classpath:").getPath() + fileLocation;
        // 获得文件输入流
        FileInputStream inputStream = new FileInputStream(new File(realPath, fileName));
        // 设置响应头、以附件形式打开文件
        response.setHeader("content-disposition", "attachment; fileName=" + fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        int len = 0;
        byte[] data = new byte[1024];
        while ((len = inputStream.read(data)) != -1) {
            outputStream.write(data, 0, len);
        }
        outputStream.close();
        inputStream.close();
    }
}
