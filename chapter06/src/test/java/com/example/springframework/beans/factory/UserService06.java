package com.example.springframework.beans.factory;

public class UserService06 {

    private String name;
    private UserDao06 userDao06;


    public String queryUserInfo() {
        return userDao06.queryUserName("10001");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDao06 getUserDao06() {
        return userDao06;
    }

    public void setUserDao06(UserDao06 userDao06) {
        this.userDao06 = userDao06;
    }
}
