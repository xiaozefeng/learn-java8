# Java 8 学习
## 新特性
- Lambda(匿名函数)
- Stream (流) 可以利用多核CPU的高性能
- 接口默认方法
## 为什么要用 Java8
- Lambda、Stream的引入了提高了程序的可读性已经性能
- Java8以前的并不能很好的利用多核处理器，Java8以前提供了多线程来利用多核处理器的性能，但是不易使用且容易出错， Java8引入了Stream API可以并行处理，利用了多核处理器的优势
- 引入Optional<T> 类处理最为头疼的空指针问题
- 新的日期API易用且不容易出错，在多线程环境下不会有安全问题
- 引入了函数式编程方法，让程序员站在更高的角度看到问题 (什么是高阶函数: `接受一个或者多个函数，返回一个函数`)

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

## 高效使用并行流定性建议
1. 测量 使用并行流可以先测量， 使用之前先测量是否结果正确，是否性能比串行流快，否则没有必要用并行流
2. 避免自动装修拆箱， 自动拆装箱会消性能，尽量使用 IntStream, DoubleStream, LongStream