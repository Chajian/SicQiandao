package com.example.demo.data;

import java.io.Serializable;

public class User implements Serializable {
    public static final Long seriaUID = 123L;
    private int id;
    private String wechatname;
    private String wechatnummber;
    private int score;
    private String account;
    private String pass;

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String passworld) {
        this.pass = passworld;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWechatname() {
        return wechatname;
    }

    public void setWechatname(String wechatname) {
        this.wechatname = wechatname;
    }

    public String getWecharnummber() {
        return wechatnummber;
    }

    public void setWecharnummber(String wechatnummber) {
        this.wechatnummber = wechatnummber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", wechatname='" + wechatname + '\'' +
                ", wecharnummber='" + wechatnummber + '\'' +
                ", score=" + score +
                '}';
    }
}
