package com.example.homework.bean;

public class User {
    private int id;
    private String account;
    private String password;
    private String name;
    private int md;

    public User() {
    }

    public User(int id, String account, String password, String name, int md) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.md = md;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", md=" + md +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMod(int md) {
        this.md = md;
    }

    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getMd() {
        return md;
    }
}
