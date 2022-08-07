package com.horn.energy_blockchain.entity;/*
 *@Author: horn
 *@DATE: 2022/8/6 0006 15:00
 *@Description 登录VO
 *@Version 1.0
 */

public class LoginVO {
    private Integer id;
    private String token;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
