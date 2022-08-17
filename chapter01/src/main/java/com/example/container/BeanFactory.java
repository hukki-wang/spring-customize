package com.example.container;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {

    private Map<String,BeanDefinition> container = new HashMap<>(16);


    public Object getBean(String beanName){
        return container.get(beanName).getBean();
    }

    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition){
        container.put(beanName,beanDefinition);
    }

}
