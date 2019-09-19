package com.top.yirenbaotop.domain;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uid;
    private String account;
    private String pwd;
    private String username;
    private String phone;
    private String idcard;
    private String mailbox;
    private Integer recommend;
    private Integer status;
    private double balance;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User(Integer uid, String account, String pwd, String username, String phone, String idcard, String mailbox, Integer recommend, Integer status, double balance) {
        this.uid = uid;
        this.account = account;
        this.pwd = pwd;
        this.username = username;
        this.phone = phone;
        this.idcard = idcard;
        this.mailbox = mailbox;
        this.recommend = recommend;
        this.status = status;
        this.balance = balance;
    }

    public User() {
    }
}
