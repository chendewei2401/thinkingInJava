package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年1月30日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 内部类:(待再次阅读)
 * 1，将一个类定义放到另一个类或接口内部，就是内部类。可以在一个方法里面或者任意作用域内定义内部类
 * 2，内部类是一种代码隐藏机制，它能访问其外围对象的所有成员，包括private元素，不论嵌套层数。外部类对象如果想要访问内部类，需要通过OutClassName.InnerClassName进行
 * 3，内部类如果是非static时，就必须在外部类对象生成后才能创建并关联。即必须拥有外部类对象才能创建内部类
 * 4，外部类对象中创建内部类对象使用.new，内部类对象返回关联外部类对象引用使用.this
 * 5，内部类声明为static时，则为嵌套内部类，不需要外部类对象就能访问
 * 6，如果内部类是匿名的，编译器会简单产生一个数字作为其标识，否则使用$符号：OutClassName$InnerClassName
 *
 * 为什么需要内部类？
 * 1，不明白
 * 2，每个内部类都能独立的继承自一个接口的实现，所以无论外部类是否已经继承了某个接口的实现，对于内部类都没有影响
 * 3，通过内部类提供闭包功能是优良的解决方案，它比指针更灵活、安全
 * 4，
 *
 */
public class Chapter10 {

    public static void main(String[] args) {

    }

}
