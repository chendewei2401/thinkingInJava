package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年2月22日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 注解:
 * 1，注解也被称为元数据，为我们在代码中添加信息提供了一种形式化的方法，是我们可以在稍后某个时刻非常方便的使用这些数据。注解的优点还包括
 *   更加干净易读的代码以及编译期类型检查等
 * 2，java.lang定义了三种注解：
 *   @Override
 *   @Deprecated
 *   @SuppressWarning
 * 3，定义注解时，需要一些元注解，包括：
 *   @Target：表示该注解可以用在什么地方
 *   @Retention：表示在什么级别保存注解信息
 *     A，source：注解将被编译器丢弃
 *     B，class：注解在class中可用，但会被vm丢弃
 *     C，runtime：在运行期也保留注解，可通过反射读取注解信息
 *   @Document：该注解包含在JavaDoc中
 *   @Inherited：允许子类继承父类中的注解
 * 4，注解也会被编译成class文件
 * 5，注解不支持继承
 *
 */
public class Chapter20 {

    public static void main(String[] args) {

    }

}
