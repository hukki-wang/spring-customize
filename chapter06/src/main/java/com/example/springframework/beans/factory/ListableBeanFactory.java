package com.example.springframework.beans.factory;

import java.util.Map;

/**
 * Listable:可列举的
 * 是一个扩展 Bean 工厂接口的接口
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
    /**
     * 返回注册表中所有bean的名称
     * @return
     */
    String[] getBeanDefinitionNames();

}
