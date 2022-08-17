package com.example.springframework.beans.factory.support;

import com.example.springframework.beans.factory.config.BeanDefinitionRegistry;
import com.example.springframework.core.io.DefaultResourceLoader;
import com.example.springframework.core.io.ResourceLoader;

/**
 * bean定义读取器的抽象
 * 抽象公共的部分，处理注册表和资源加载的处理
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry){
       this(registry,new DefaultResourceLoader());
    }
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader){
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return new DefaultResourceLoader();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }
}
