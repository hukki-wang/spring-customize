package com.example.springframework.beans.factory.support;

import com.example.springframework.beans.factory.config.BeanDefinition;

/**
 * 为什么使用抽象类？方便后续的拓展，一个优秀的产品要支持修改关闭，拓展开放
 * 一个类处理一种职责，单一职责设计原则
 * 创建bean的职责交给AbstractAutowireCapableBeanFactory
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Instantiation of bean failed", e);
        }
        //添加到注册表中
        addSingleton(beanName,bean);
        return bean;
    }
}
