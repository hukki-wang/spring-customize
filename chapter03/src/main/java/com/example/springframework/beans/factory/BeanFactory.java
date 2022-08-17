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
    Object getBean(String beanName,Object... args);
}
