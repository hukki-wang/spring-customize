package com.example.springframework.beans.factory;

public class UserService05 {

    private String name;
    private UserDao05 userDao05;
    public UserService05(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDao05 getUserDao05() {
        return userDao05;
    }

    public void setUserDao05(UserDao05 userDao05) {
        this.userDao05 = userDao05;
    }

    public void queryUserInfo(){
        userDao05.query();;
        System.out.println(name+":test");
    }
}
