package com.example.homework.bean;

public class Homework {
    private int id;
    private String cname;
    private String account;
    private String filename;
    private int score;
    private String jname;

    public Homework(int id, String cname, String account, String filename, int score, String jname) {
        this.id = id;
        this.cname = cname;
        this.account = account;
        this.filename = filename;
        this.score = score;
        this.jname = jname;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", account='" + account + '\'' +
                ", filename='" + filename + '\'' +
                ", score=" + score +
                '}';
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public Homework() {
    }
}
