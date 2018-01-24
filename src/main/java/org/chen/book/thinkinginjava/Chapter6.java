package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年1月17日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 访问权限控制:
 *
 * 1，权限控制：public、protected（当前包和子类）、default（当前包）和private
 * 2，java类文件里最多可以有一个public类，该类的名称必须和文件的名称相同（包括大小写），如果还有其他类的话，包之外是无法访问的，
 *   因为该类不是public的。
 * 3，Java解释器的运行过程如下：先找到classpath，classpath包含一个或多个目录，用作查找.class文件的根目录。从根目录开始，
 *   解释器获取包的名称并将每个句点替换成反斜杠，以从class根中产生一个路径名称
 * 4，classpath包括：
 * 5，如果classpath里没有点号（.），Java就不会在当前目录找。
 * 6，普通类只能是public或者default权限，只有内部类才可以是private或者protected权限。但如果构造器设置成private的，则当前类就不能被继承
 *
 *
 */
public class Chapter6 {

    public static void main(String[] args) {


    }

}
