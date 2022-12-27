package com.example.homework.bean;

public class Course {
    private int id;
    private String cname;
    private String tname;


    public Course(int id, String cname, String tname) {
        this.id = id;
        this.cname = cname;
        this.tname = tname;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }



    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}
