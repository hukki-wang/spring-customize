package com.example.springframework.beans.factory.config;

/**
 * 引用属性
 */
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName){
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
