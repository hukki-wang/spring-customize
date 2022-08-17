package com.example.springframework.beans.factory;

public class BeansException extends RuntimeException{

    public BeansException(String msg,Exception e){
        super(msg,e);
    }

    public BeansException(String msg){
        super(msg);
    }

}
