package com.example.homework.mapper;

import com.example.homework.bean.Course;
import com.example.homework.bean.Homework;
import com.example.homework.bean.Job;
import com.example.homework.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User selectbyaccount(String account);
    List<Course> selectallcourse();
    void deletecourse(String cname);
    void insertcourse(Course course);
    List<User> selectbymod(int md);
    int insertuser(User user);
    void deleteuser(String account);
    List<Course> selecybytname(String tname);

    List<Job> selectmyjob(String cname);

    void insertjob(Job job);

    void deletjname(String jname);

    void inserthomework(Homework homework);

    List<Homework> gethomework(String account);

    List<Homework> getallhomework(String cname);

    void givescore(@Param("account") String account,@Param("jname") String jname, @Param("score") int score);
}
