package com.example.springframework.beans.factory;

import com.example.springframework.beans.factory.config.BeanDefinition;
import com.example.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class TestDefaultFactory {

    @Test
    public void test(){
        //实例化
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //注册
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        factory.registerBeanDefinition("userService",beanDefinition);

        //使用
        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();
    }
}
