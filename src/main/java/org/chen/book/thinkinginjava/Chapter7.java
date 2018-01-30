package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年1月18日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 复用类:
 * 1，两种代码复用机制：组合+继承。组合和继承都允许在新的类中放置子对象，组合是显式的做，而继承是隐式的做。
 * 2，每个非基本类型都隐式继承了Object的toString方法，在编译器需要String，而你只有Object的时候，该方法会被隐式调用
 * 3，当创建一个子类对象时，该子类对象内部包含了一个父类对象，这个父类对象与你直接创建的父类对象是一样的
 * 4，Java会自动在子类的构造器中插入父类构造器的调用
 * 5，Java对象的构建过程是从父类向下扩展的，所以父类在子类构造器可以访问它之前就已经完成了初始化
 * 6，类的清理顺序同生成顺序相反。
 * 7，如果Java的父类拥有某个已经被多次重载的方法名称，那么子类中重新定义该方法名称并不会屏蔽其在父类中的任何版本
 * 8，对于基本类型，final使数值恒定不变；对于对象引用，final使引用恒定不变，但对象本身是可以修改的
 * 9，Java允许生成空白final，即被声明为final但又未给定初始值。无论什么情况下，编译器都要确保空白final在使用前被初始化
 * 10，Java允许在参数列表中以声明的方式将参数指明为final
 * 11，final方法不允许继承类对其进行覆盖修改。早期编译器可以将final方法转为内嵌调用加快速度，但JDK5以后JVM已经做了相应优化，不需要在
 *    做如此处理。因此，只有在想要明确禁止覆盖时，才将方法设置为final
 * 12，类中所有private方法都隐式是final的，因此对private方法加final修饰没有任何意义
 * 13，final类不允许继承
 * 14，继承与初始化：
 *    a，在遇到类调用时，先加载class对象，同时完成static变量的初始化，有父类时父类先加载
 *    b，当遇到new时，先为该对象分配内存区域，并将该内存区域清零、此时成员变量都会被执行初始化，有父类时父类先new
 *    c，调用构造器，有父类时会默认先调用父类构造器
 *    @link Beetle.java
 *
 *
 */
public class Chapter7 {

    public static void main(String[] args) {


    }

}
