package com.example.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.example.springframework.beans.factory.BeansException;
import com.example.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.example.springframework.beans.factory.config.BeanDefinition;
import com.example.springframework.beans.factory.config.BeanPostProcessor;
import com.example.springframework.beans.factory.config.BeanReference;
import com.example.springframework.beans.factory.support.property.PropertyValue;
import com.example.springframework.beans.factory.support.property.PropertyValues;

import java.lang.reflect.Constructor;

/**
 * 为什么使用抽象类？方便后续的拓展，一个优秀的产品要支持修改关闭，拓展开放
 * 一个类处理一种职责，单一职责设计原则
 * 创建bean的职责交给AbstractAutowireCapableBeanFactory
 * 创建bean以及其他方法调用处理
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

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
            // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException(beanName+" Instantiation of bean failed", e);
        }
        //添加到注册表中
        addSingleton(beanName,bean);
        return bean;
    }

    /**
     * 初始化bean，并且执行前置增强和后置增强
     * @param beanName
     * @param bean
     * @param beanDefinition
     * @return
     */
    private Object initializeBean(String beanName,Object bean,BeanDefinition beanDefinition){
        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 待完成内容：invokeInitMethods(beanName, wrappedBean, beanDefinition);
        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for(BeanPostProcessor processor : getBeanPostProcessors()){
            Object current = processor.postProcessAfterInitialization(result,beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    /**
     * 执行init方法
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    private void invokeInitMethods(String beanName,Object bean,BeanDefinition beanDefinition){

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





















    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
