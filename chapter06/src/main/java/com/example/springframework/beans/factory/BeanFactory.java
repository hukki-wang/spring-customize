package com.example.springframework.beans.factory;

/**
 * spring的bean工厂门面
 */
public interface BeanFactory {

    /**
     * 获取bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName);

    /**
     * 获取bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName,Object... args) throws BeansException;

    /**
     * 指定class类型获取Class对象
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
