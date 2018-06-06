package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年2月5日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 类型信息:
 * 1，运行时类型信息可以让程序在运行时发现和使用类型信息。
 * 2，Java在运行时识别对象和类型信息主要有两种方式：一种是传统的RTTI（运行时类型识别Run-Time Type Identification），
 *   主要由Class类实现，它假定我们在编译时已经知道了所有类型，多态即基于此；另一种是反射机制，它运行我们在运行时发现和使用类的信息
 * 3，Java程序在它运行前并非被完全加载，其各个部分是在必需时才加载的。类加载器首先检查该类的class对象是否已经加载，如果尚未加载，
 *   默认的类加载器就会根据类名查找class文件，该class文件被加载时，会接受验证，确保没有被破坏，且不包含不良代码。class对象被载入内存后，
 *   被用来创建这个类的对象。
 * 4，Class.forName("packageName.className")可以使我们不需要持有该类型的对象就能获得它的class引用
 * 5，Class方法：getSimpleName()、getCanonicalName()、isInterface()、newInstance()、isInstance()、isAssignableFrom()
 * 6，使用Class的newInstance()来创建实例的类，必须带有默认的构造参数(JVM默认添加的也可)
 * 7，Java还可以通过类字面常量来生成对class对象的引用，如Collections.class。这样比forName更安全，因为在编译时就会受到检查，不需要放到try/catch中。
 *   类字面常量不仅可以用于类，还可以用于接口、数组和基本类型
 * 8，使用.class来创建对Class对象的引用时，不会自动初始化该Class对象。为了使用类而做的准备工作实际包含如下三个步骤：
 *   A，加载：这是由类加载器执行，通常在classpath所指定的路径中查找字节码，并从这些字节码中创建一个class对象
 *   B，链接：在链接阶段将验证类中的字节码，为静态域分配空间，并且如果必要的话，将解析这个类创建的对其他类的所有引用
 *   C，初始化：如果该类具有超类，则对其初始化，执行静态初始化器和静态初始化块
 *   初始化被延迟到了对静态方法（构造器隐式地是静态的）或者非常数静态域进行首次引用时才执行，即
 *   通过.class获得class引用时不会触发该class的初始化、Class.forName会立刻初始化。可参考ClassInitialization.java。
 * 9，如果一个static final变量是编译期常量，则这个变量不需要对类进行初始化就能读取；如果一个static域不是final的，那么在对它访问之前
 *   要先进行链接（为这个域分配存储空间）和初始化（初始化该存储空间）
 * 10，RTTI的形式包括：
 *   A，强制类型转换：由RTTI保证类型转换的正确性，错误时会抛出ClassCaseException异常
 *   B，通过查询Class对象获取运行时所需的信息
 *   C，通过instanceof确认对象是否是某个特定类型的实例：instanceof会判断是否是该类或者其子类，用==比较class则只判断是否是该类
 * 11，IllegalAccessException表示违反了Java安全机制，比如调用构造器为private的类的newInstance方法
 * 12，在编译时，编译器就需要知道所有通过RTTI来处理的类。但有时候我们希望在跨网络的远程平台上创建和运行对象，即RMI。这需要用到反射。
 * 13，Class类与java.lang.reflect类库一起对反射的概念进行了支持，该类库包含了Field、Method及Constructor类，每个类都实现了Member接口。
 *   这些类型的对象是由JVM在运行时创建的，用以表示未知类里对应的成员。这样就可以使用Constructor创建新对象，用get()和set()方法读取和修改
 *   与Field对象关联的字段，用invoke()方法调用与Method对象关联的方法。另外，还可以调用getFields()、getMethods()和getConstructors()等
 *   方法。这样，匿名对象的类信息就能在运行时被完全确定下来，而在编译时不需要知道任何事情。
 * 14，使用反射可以调用匿名对象的所有域和方法，包括private，只要在Field或Method对象上调用setAccessible(true)即可。
 * 15，对RTTI来说，编译器在编译时打开和检查.class文件，而对于反射机制来说，.class文件在编译时是不可获取的，所以是在运行时打开和检查.class文件。
 * 16，动态代理：Java动态代理比代理的思想更向前迈进了一步，因为它可以动态的创建代理并动态的处理对所有代理方法的调用。在动态代理上锁做的所有调用
 *   都会被重定向到单一的调用处理器上。
 * 17，空对象：有时候需要检查null，有时候你可以合理的假设根本不会遇到null，有时候甚至通过NullPointException来探测异常也可以接受。
 * 18，面向对象编程语言让我们在凡是可以使用多态的地方都使用多态机制，只在必须的时候使用RTTI。
 */
public class Chapter14 {

    public static void main(String[] args) {
        System.out.println(int.class);
        System.out.println(Integer.TYPE);
        System.out.println(Integer.class);
    }

}
