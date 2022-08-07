package com.horn.energy_blockchain.entity;

public class Login {
    private String loginName;
    private String passWord;

    public Login() {
    }

    public Login(String loginName, String passWord) {
        this.loginName = loginName;
        this.passWord = passWord;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
