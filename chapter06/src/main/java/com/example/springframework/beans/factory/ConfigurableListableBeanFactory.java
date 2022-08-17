package com.example.springframework.beans.factory;

import com.example.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.example.springframework.beans.factory.config.BeanDefinition;
import com.example.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.Map;

/**
 * 提供分析和修改Bean以及预先实例化的操作接口
 */
public interface ConfigurableListableBeanFactory extends ConfigurableBeanFactory, AutowireCapableBeanFactory, ListableBeanFactory {

    /**
     * 获取BeanDefinition
     * @param beanName
     * @return
     */
    BeanDefinition getBeanDefinition(String beanName);
}
