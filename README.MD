# Java 8 学习
## 新特性
- Lambda(匿名函数)
- Stream (流) 可以利用多核cpu
- 默认方法
## 为什么要用 Java8

# 什么是函数式接口
> 一言蔽之：只定义了一个抽象方法的接口


# 方法引用 (仅仅涉及单一方法的Lambda语法糖)
###  指向静态方法的引用: `例如Integer的parseInt方法， Integer::parseInt`
### 指向对象实例方法的引用: `例如有一个对象a,有一个abs()方法, a::abs`
### (作为参数)指向对象的实例方法引用: `例如有一个字符串str,需要调用toUpperCase(str), String::toUpperCase`
### 构造函数引用 ClassName::new

# Stream 流
> 从支持数据处理操作的源生成的元素序列

## 流和集合的区别
### 集合是数据结构：它的主要目的是特定的时间/空间复杂度存贮和访问元素
### 流的目的在于表达计算