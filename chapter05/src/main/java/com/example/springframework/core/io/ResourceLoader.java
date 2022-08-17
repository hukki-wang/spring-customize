package com.example.springframework.core.io;

public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";
    /**
     * 加载资源
     * @param location
     * @return
     */
    Resource getResource(String location);
}
