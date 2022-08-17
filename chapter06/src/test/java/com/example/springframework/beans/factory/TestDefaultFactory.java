package com.example.springframework.beans.factory;

import com.example.springframework.beans.factory.config.BeanDefinition;
import com.example.springframework.beans.factory.config.BeanReference;
import com.example.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.example.springframework.beans.factory.support.property.PropertyValue;
import com.example.springframework.beans.factory.support.property.PropertyValues;
import com.example.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.example.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class TestDefaultFactory {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        UserService06 userService06 = (UserService06) context.getBean("userService06");
        System.out.println("test"+userService06.queryUserInfo());
        System.out.println(userService06.getName());
    }
}
