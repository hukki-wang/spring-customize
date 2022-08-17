package com.example.springframework.beans.factory;

/**
 * Listable:可列举的
 * 是一个扩展 Bean 工厂接口的接口
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 返回注册表中所有bean的名称
     * @return
     */
    String[] getBeanDefinitionNames();

}
