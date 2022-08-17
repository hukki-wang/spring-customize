package com.example.springframework.beans.factory.support;

import com.example.springframework.beans.factory.BeansException;
import com.example.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * bean实例化策略
 * 1.jdk
 * 2.cglib
 */
public interface InstantiationStrategy {

    /**
     * 实例化对象
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
