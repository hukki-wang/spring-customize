package com.example.springframework.beans.factory.support;

import com.example.springframework.beans.factory.config.SingletonRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonRegistry {

    private final Map<String,Object> singletonObjects = new HashMap<>(16);

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 添加单例对象，可以被子类给重写
     * @param beanName
     * @param singletonObject
     */
    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }
}
