package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年1月18日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 多态:
 * 1，多态，也叫后期绑定、动态绑定或运行时绑定，通过分离做什么和怎么做，从另一角度将接口和实现分离开来
 * 2，Java中除了static和final（private属于final方法）外，其他所有方法都是后期绑定。
 * 3，只有方法调用是多态的，变量的访问在编译器进行解析，不是多态的。因此如果想访问运行时绑定类的变量，需要显式指定，否则直接访问变量时
 *   默认得到的就是左侧类对象的变量。因此，为了避免 混淆，父类和子类变量名不应该用一样的。
 *   @link FieldAccess.java
 * 4，继承时初始化顺序：
 *    A，调用父类构造器。反复递归到最底层的父类，从最底层的父类开始，先初始化成员变量，然后调用构造器
 *    B，一级级处理，直到最终的子类
 *    @link
 *
 *
 *
 *
 */
public class Chapter8 {

    public static void main(String[] args) {

    }

}
