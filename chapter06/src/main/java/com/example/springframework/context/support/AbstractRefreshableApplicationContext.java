package com.example.springframework.context.support;

import com.example.springframework.beans.factory.BeansException;
import com.example.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.example.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * 结合工厂和加载xml到xml
 * 并将相应的处理交给子类实现
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }


    private DefaultListableBeanFactory createBeanFactory(){
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);
}
