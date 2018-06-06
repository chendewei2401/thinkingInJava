package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年2月5日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 字符串:
 * 1，String对象是不可变的。String类里的方法，都是创建一个新的String对象，以包含一个全新的String对象
 * 2，每当String对象作为方法参数传递时，是传递的引用
 * 3，StringBuilder是Java5引入的非线程安全、但速度更快的字符串操作工具类，之前使用的是线程安全的StringBuffer
 * 4，如果某个对象出现在字符串表达式中，toString方法会被自动调用，以生成表示该对象的String，参考InfiniteRecursion.java
 * 5，Java的所有格式化功能都由java.util.Formatter类处理，它将格式化字符串与数据翻译成需要的结果：
 *      new Formatter().format("%s The Turtle is at (%d,%d)\n", strName, intX, intY);
 *      或者
 *      String.format("%s The Turtle is at (%d,%d)\n", strName, intX, intY);
 * 6，Formatter格式里，%d代表数字，%s代表字符串，%f代表浮点数，%b代表布尔值，%c代表字符。同时可以输出区域的长度，
 *   如%5s代表字符串的长度为5，右对齐，不够补充空格。%-5s表示左对齐，通过-控制对其方向
 * 7，Pattern类的作用在于编译正则表达式后创建一个匹配模式，Matcher类使用Pattern实例提供的模式信息对正则表达式进行匹配
 *   参考Regular.java
 *
 */
public class Chapter13 {

    public static void main(String[] args) {

    }

}
