package com.example.springframework.beans.factory.support;

import com.example.springframework.beans.factory.BeansException;
import com.example.springframework.beans.factory.config.BeanDefinitionRegistry;
import com.example.springframework.core.io.Resource;
import com.example.springframework.core.io.ResourceLoader;

/**
 * BeanDefinitionReader读取xml资源流
 */
public interface BeanDefinitionReader {


    /**
     * 读取xml资源首先需要资源加载器
     * @return
     */
    ResourceLoader getResourceLoader();


    /**
     * 其次需要资源
     * 接口方法重载
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(Resource... resources) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;
    void loadBeanDefinitions(String... locations) throws BeansException;

    /**
     * 读取到资源需要加载都注册表，所以需要可以获取到注册表
     * @return
     */
    BeanDefinitionRegistry getRegistry();
}
