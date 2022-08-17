package com.example.springframework.beans.factory;

import com.example.springframework.beans.factory.config.BeanDefinition;
import com.example.springframework.beans.factory.config.BeanReference;
import com.example.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.example.springframework.beans.factory.support.property.PropertyValue;
import com.example.springframework.beans.factory.support.property.PropertyValues;
import org.junit.Test;

public class TestDefaultFactory {

    @Test
    public void test(){
        //实例化
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //注册UserDao
        BeanDefinition beanDefinition = new BeanDefinition(UserDao.class);
        factory.registerBeanDefinition("userDao",beanDefinition);

        //构建属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        //注册UserService
        BeanDefinition userBeanDefinition = new BeanDefinition(UserService.class, propertyValues);
        factory.registerBeanDefinition("userService",userBeanDefinition);

        //使用
        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();
    }
}
