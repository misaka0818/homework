package com.example.homework.bean;

public class Job {
    private int id;
    private String jname;
    private String cname;
    private String jobdetail;

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jname='" + jname + '\'' +
                ", cname='" + cname + '\'' +
                ", jobdetail='" + jobdetail + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getJobdetail() {
        return jobdetail;
    }

    public void setJobdetail(String jobdetail) {
        this.jobdetail = jobdetail;
    }

    public Job(int id, String jname, String cname, String jobdetail) {
        this.id = id;
        this.jname = jname;
        this.cname = cname;
        this.jobdetail = jobdetail;
    }

    public Job() {
    }
}
