package com.example.springframework.beans.factory.config;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName,BeanDefinition beanDefinition);
}
