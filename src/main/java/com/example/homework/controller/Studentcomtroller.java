package com.example.homework.controller;

import com.example.homework.bean.Homework;
import com.example.homework.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/student")
public class Studentcomtroller {
    private String fileLocation="static/files";
    @Autowired
    Studentservice studentservice;
    @RequestMapping("/job")
    public ModelAndView getjobs(String who,String cname,String account){
        ModelAndView modelAndView=new ModelAndView("homework.html");
        modelAndView.addObject("who",who);
        modelAndView.addObject("jobs",studentservice.getmyjob(cname));
        modelAndView.addObject("account",account);
        modelAndView.addObject("homeworks",studentservice.gethomework(account));
        return modelAndView;
    }
    @PostMapping("/homework")
    public ModelAndView gethomework(MultipartFile file,String cname,String account,String jname,String who) throws IOException {
        Date date=new Date();
        ModelAndView modelAndView=new ModelAndView("homework.html");
        modelAndView.addObject("who",who);
        modelAndView.addObject("jobs",studentservice.getmyjob(cname));
        modelAndView.addObject("account",account);
        String realPath = ResourceUtils.getURL("classpath:").getPath() + fileLocation;
        File newFile = new File(realPath);
        if (!newFile.exists()) newFile.mkdirs();
        String fileName = date.getTime() +"@" + file.getOriginalFilename();
        file.transferTo(new File(newFile, fileName));
        Homework homework=new Homework(0,cname,account,fileName,-1,jname);
        studentservice.inserhomework(homework);
        modelAndView.addObject("homeworks",studentservice.gethomework(account));
        return modelAndView;
    }
}
