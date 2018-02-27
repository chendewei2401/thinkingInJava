package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年2月5日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 异常处理:
 * 1，Java使用异常来提供一致的错误报告模型，把“正常流程”代码和“出了问题怎么办”的代码相分离
 * 2，异常和普通问题是不一样的。普通问题是指在当前上下文里开发者知道如何处理该问题，程序可以继续执行下去；而异常是指开发者不知道
 *   如何处理该问题，只能从当前方法或环境跳出，把问题提交给上一级，即抛出异常，程序不再沿正常路径执行下去。
 * 3，异常也是通过new在堆上创建的
 * 4，异常的根类为Throwable对象，Exception和Error类继承了Throwable对象，Error为程序无法处理的错误，如VirtualMachineError；
 *   程序只能处理Exception，而Exception也分为两种，unchecked exception和checked exception
 * 5，unchecked exception为运行时异常，即RuntimeException及其子类，比如常见的NullPointerException、IndexOutOfBoundsException。
 *   对于运行时异常，它们被JVM抛出并会自动被捕获，所以java编译器不要求必须进行异常捕获处理或者抛出声明，由开发者自行决定。
 * 6，checked exception也称非运行时异常，即运行时异常以外的异常就是非运行时异常，比如常见的IOException和SQLException。
 *   对于非运行时异常java编译器强制程序员必须进行捕获处理，如果不进行捕获或者抛出声明处理，编译都不会通过
 * 7，Throwable类中，printStackTrace方法用来打印从方法调用处直到异常抛出处的方法调用序列，输出到标准错误流
 * 8，异常被catch后重新抛出的话，后续catch子句将被忽略，且该异常的printStackTrace打印的是原来抛出点的调用栈信息，而非重新抛出点的信息，
 *   如果想要更新，可使用fillInStackTrace方法
 * 9，异常链：如果想要捕获异常后抛出另一个异常，并且希望把原始异常信息保存下来，就是异常链。可使用exception.initCause或者构造器来构造新异常
 * 10，在异常处理时，如果要把除内存之外的其他资源恢复到他们的初始状态，就要用finally子句，这种需要处理的资源包括：已经打开的文件或者网络连接等
 * 11，finally子句肯定会执行，不论try/catch里是否有continue、break、return还是异常没有被捕获
 * 12，在finally子句里加return，抛出的异常会被吞没，参考ReturnInFinally.java
 * 13，当覆盖方法时，只能抛出在基类方法里列出的哪些异常或者它们的父异常，即异常在继承时变小了，而非像普通子类继承时扩大父类功能。这样保证了对象的可替换性
 * 14，异常在多个catch子句的情况下，找到一个匹配后就不再往下执行
 * 15，异常处理的一个重要原则是：只有在你知道如何处理的情况下才会捕获异常
 * 16，Martin Fowler：总体而言，我觉得异常很不错，但Java的被检查异常带来的麻烦比好处多
 * 17，“报告”功能是异常的精髓所在
 *
 */
public class Chapter12 {

    public static void main(String[] args) {

    }

}
