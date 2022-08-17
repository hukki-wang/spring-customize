package com.example.springframework.context.support;

import com.example.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.example.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 加载xml到注册表
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
