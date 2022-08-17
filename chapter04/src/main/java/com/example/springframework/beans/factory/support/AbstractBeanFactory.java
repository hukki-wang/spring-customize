package com.example.springframework.beans.factory.support;

import com.example.springframework.beans.factory.BeanFactory;
import com.example.springframework.beans.factory.config.BeanDefinition;

/**
 * 模板设计模式，定义bean创建流程
 * 1.获取beanDefinition定义
 * 2.创建bean
 * 问题：bean容器存放bean应该如何处理？spring默认单例，单例注册表的处理如何解决？
 * 1）抽象出单例注册表接口
 * 2）提供单例注册表的默认实现
 * 单例缓存
 * 创建完成的对象需要注册到单例注册表中(那么怎么办？引入单例注册表或者继承单例注册表,采用继承的方式)
 * 问题：创建bean，注册到单例表形成闭环需要交给子类实现，那么需要提供抽象类的子类实现
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 为了保证getBean的拓展性，一般采用protect可以交给子类去重写
     * @param beanName
     * @return
     */
    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String name, Object... args){
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(String beanName,final Object[] args){
        //如果没有获取到单例，那么创建，如果已经注册到单例注册表中，那么直接返回
        Object bean = getSingleton(beanName);
        if (bean != null){
            return (T)bean;
        }
        //1.获取beanDefinition
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        //2.根据beanDefinition创建bean
        return (T)createBean(beanName,beanDefinition,args);
    }


    /**
     * 获取beanDefinition交给子类实现
     * @param beanName
     * @return
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    /**
     * 创建bean交给子类去实现
     * @param beanName
     * @param beanDefinition
     * @return
     */
    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args);
}
