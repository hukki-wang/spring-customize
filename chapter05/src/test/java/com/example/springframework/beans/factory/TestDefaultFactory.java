package com.example.springframework.beans.factory;

import com.example.springframework.beans.factory.config.BeanDefinition;
import com.example.springframework.beans.factory.config.BeanReference;
import com.example.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.example.springframework.beans.factory.support.property.PropertyValue;
import com.example.springframework.beans.factory.support.property.PropertyValues;
import com.example.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.junit.Test;

public class TestDefaultFactory {

    @Test
    public void test(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService05 service05 = (UserService05) factory.getBean("userService05");
        service05.queryUserInfo();
    }
}
