package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年2月22日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 枚举类型:
 * 1，创建enum时，编译器会为你生成一个相关的类，该类继承自java.lang.Enum，并自动实现了Serializable和Comparable接口
 * 2，Enum可用方法：
 *   A，values()：返回enum实例的数组，数组中的元素保持在enum里声明的顺序，是由编译器自动添加的static方法
 *   B，valuesOf()：根据给定的名字返回enum实例
 *   C，ordinal()：返回enum实例声明时的次序，从0开始
 *   D，name()：返回enum实例声明时的名字，和toString效果相同
 * 3，EnumMap是一种特殊的Map，它的key只能来自一个Enum，由于Enum实例个数固定，所以EnumMap实现了没有哈希冲突的完美哈希函数，速度很快
 *
 */
public class Chapter19 {

    public static void main(String[] args) {

    }

}
