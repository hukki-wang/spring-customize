package com.example.springframework.beans.factory;

public class UserService {
    private String name;
    public UserService(String name){
        this.name = name;
    }
    public UserService(){}

    public void queryUserInfo(){
        System.out.println(name+":test");
    }
}
