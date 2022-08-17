package com.example.springframework.util;

public class ClassUtils {

    public static ClassLoader getDefaultClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }
}
