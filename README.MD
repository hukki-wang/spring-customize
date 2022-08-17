# spring自定义学习
将bean的创建做到极致，学习spring是如何做到设计一个优秀的产品
- spring的核心ioc和aop是如何实现的？
- spring是如何控制bean的创建？
- ioc用于创建bean，aop代理bean是如何注入到spring容器的？
## chapter01
思考：如果需要创建一个bean的容器，需要哪些东西？
1）new Object，那么一个对象是如何实例化的是如何存储的？
2）存储Object的数据结构，用什么数据结构存储比较合适呢？
## chapter02
将创建对象的过程拓展，并通过设计保证程序的拓展性
1）beanDefinition
2）创建bean

## chapter03
目前创建对象是通过newInstance处理，没有参数可以成功，那么存在参数无法处理，那么需要去丰富实例化策略

## chapter04
对象还存在属性，那么实例化完成后需要对有属性的BeanDefinition进行相关填充

## chapter05
xml资源解析，将xml文件定义的bean加载到注册表,让bean的管理更容易

## chapter06
通过配置更好的管理bean，但是使用bean的方式DefaultListableBeanFactory实例化处理，应该是面向用户的友好处理，所以引入上下文可以获取bean生命周期的每一个细节处理。
之所以不能将DefaultListableBeanFactory面向用户，因为我们后续可能还需要对spring继续拓展。