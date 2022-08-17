package com.example.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.example.springframework.beans.factory.BeansException;
import com.example.springframework.beans.factory.config.BeanDefinition;
import com.example.springframework.beans.factory.config.BeanReference;
import com.example.springframework.beans.factory.support.property.PropertyValue;
import com.example.springframework.beans.factory.support.property.PropertyValues;

import java.lang.reflect.Constructor;

/**
 * 为什么使用抽象类？方便后续的拓展，一个优秀的产品要支持修改关闭，拓展开放
 * 一个类处理一种职责，单一职责设计原则
 * 创建bean的职责交给AbstractAutowireCapableBeanFactory
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    //默认cglib实例化
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) {
        Object bean;
        try {
            //实例化
            bean = createBeanInstance(beanDefinition,beanName,args);
            //属性填充
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException(beanName+" Instantiation of bean failed", e);
        }
        //添加到注册表中
        addSingleton(beanName,bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args){
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * 给bean填充属性
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName,Object bean,BeanDefinition beanDefinition) {
        //得到bean定义的所有属性
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                //如果是引用类型
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    //调用getBean创建对象(在创建对象的时候做实例化和属性填充并注册到注册表中)
                    value = getBean(beanReference.getBeanName());
                }
                //设置属性值
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }



















    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
