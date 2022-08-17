package com.example.springframework.beans.factory.config;

/**
 * spring单例注册表
 * 也是spring用来存储bean对象的容器Map
 */
public interface SingletonRegistry {

    /**
     * 获取单例bean对象
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
