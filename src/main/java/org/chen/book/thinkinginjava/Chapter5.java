package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年1月18日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 初始化与清理:
 * 1，随着计算机的发展，“不安全”的编程方式已逐渐成为编程代价高昂的主因之一，而【初始化】和【清理】正是涉及安全的两个问题。
 * 2，C++引入了构造器，可以在创建对象的时候自动被调用；Java也采用了构造器，并额外提供了垃圾回收器，Java会在用户有能力操作对象之前
 *   自动调用响应的构造器。
 * 3，构造器的名称与类名完全一致（包括大小写），如果类中没有写构造器，编译器会自动创建一个默认的构造器。
 * 4，当JVM看到new的时候，会为对象分配内存空间，并调用相应的构造器
 * 5，如果传入的数据类型小于方法中声明的参数类型，实际数据类型就会被提升
 * 6，在构造器中可以通过this调用另一个构造器，但不能多次调用，且调用位置必须在起始处；另外编译器也禁止非构造方法调用构造方法
 * 7，垃圾回收器只回收由new分配的内存，不通过new产生的直接内存，比如网络和文件读写等调用本地方法时产生的内存，需要在finalize()
 *   方法中销毁，一旦垃圾回收器准备释放对象占用的存储空间，将首先调用finalize方法。
 * 8，无论是垃圾回收还是finalize，都不保证一定会发生，如果JVM并未面临内存耗尽的情形，它是不会浪费时间去执行垃圾回收以恢复内存的。
 *   因为垃圾回收本身也是有开销的，要是不使用它，那就不用支付这部分开销了。
 * 9，数组是相同类型的、用一个标识符封装到一起的一个对象序列或基本类型数据序列
 * 10，可变参数列表
 * 11，创建Enum类时，会自动包含toString、ordinal和values方法
 *
 *
 * 垃圾回收器的工作方式：
 * 1，垃圾回收器对对象重新排列，实现了一种高速的、有无限空间可供分配的堆模型。
 * 2，引用计数垃圾回收技术：是一种简单但速度很慢的垃圾回收技术，每个对象都包含一个引用计数器，当有引用连接至对象时，引用计数加1，当引用离开作用域
 *   或者被置为null时，引用计数减一，垃圾回收器在含有全部对象的列表上遍历，当发现某个对象的引用为0时，就释放其占用的空间。
 *   这个回收技术有个缺陷，当对象之间存在循环引用时，就会出现内存泄露。
 * 3，自适应垃圾回收技术：对任何活的对象，一定能最终追溯到其存活在栈或静态存储区（vm stack）之中的引用。这个引用链条可能会穿过数个对象层次。
 *   因此，如果从栈和静态存储区开始，遍历所有的引用，就能找到所有活的对象。
 *   对于发现的每个引用，必须追踪它所引用的对象，然后是此对象包含的所有引用，如此反复进行。
 *   找到存活对象后，如何处理，取决于不同的Java虚拟机实现：
 *   A，停止-复制模式：先暂停程序的运行，然后将所有存活的对象从当前堆复制到另一个堆，没有被复制的全部是垃圾。新堆保持紧凑排列，可以直接分配新地址
 *   B，标记-清扫模式：复制模式将内存从一处复制到另一处，这很浪费，一些虚拟机会先检查，要是没有新垃圾产生，就会转换到标记清扫模式。
 *     一般而言，标记清扫模式速度相当慢，但只会产生少量垃圾或者不产生垃圾的时候，他的速度就很快了
 *     实现思路：从栈和静态存储区出发，遍历所有的引用，进而找出所有存活的对象。每当他找到一个存活对象，就会给对象设一个标记，这个过程不会回收任何对象，
 *             只有全部标记动作完成后，清理才开始。在清理过程中，没有被标记的对象将被释放，不会发生任何复制动作。剩下的堆空间是不连续的。
 * 4，自适应的、分代的、停止-复制、标记-清除式垃圾回收器：如果对象较大时，JVM内存分配以较大块，每个块都用相应的代数来记录它是否还存活，
 *    垃圾回收器定期进行完整的清理动作：不复制大型块，只增加其代数，内含小型对象的块则被复制并整理。Java虚拟机进行监控，如果所有对象都很稳定，GC效率降低的话，
 *    就切换到标记-清扫模式；同样JVM监控标记-清扫的效果，要是堆上出现很多碎片，就会切换回停止-复制方式，这就是自适应技术。
 * 5，JVM使用即时编译器（Just-In-Time）技术，通过把程序部分或者全部翻译成本地机器码来提升速度，实现方式如下：
 *    当JVM为类创建第一个对象时，JVM会先找到其class文件，然后将该类的字节码装入内存，同时采用惰性评估的方式，将会被执行的代码编译成本地机器码，
 *    代码每次执行的时候，都会做一些优化，所以执行的次数越多，它的速度就越快。
 *
 * 初始化
 * 1，Java尽量保证所有变量使用前都会被初始化：全局变量默认赋值，局部变量未初始化会编译报错
 * 2，初始化在构造器调用之前进行，是无法被阻止的。
 * 3，在类内部，变量定义的先后顺序决定了初始化的顺序，即使散布于方法之间，它们仍然会在任何方法被调用之前被初始化，示例参考：
 *    @link initialization.java
 *    类与类之间的变量初始化顺序按class加载的顺序来。
 * 4，static不能用于局部变量，默认初始化规则同非静态变量。类初始化时先静态变量，然后是非静态变量。static在类加载时只初始化一次，
 *    而非static每new一次就会初始化一次。且类只有在被new时才加载并分配内存进行初始化。示例参考：
 *    @link staticInitialization.java
 *
 * 对象的创建过程：
 * 假设有个名为Dog的类
 * 1，当首次创建Dog对象，或者访问Dog类的静态方法/静态变量时，JVM查找类路径，以定位Dog.class文件
 * 2，然后JVM载入Dog.class，创建Dog的Class对象，此时执行静态初始化（通过.class获得class引用时不会触发该class的初始化、Class.forName会立刻初始化）
 * 3，当用new创建对象时，首先在堆上为Dog对象分配足够的存储空间
 * 4，这块存储空间会被清零，然后将Dog的成员变量默认初始化
 * 5，执行代码里定义的变量初始化语句
 * 6，执行构造器语句
 *
 * static
 * 1， 静态属性、静态方法和非静态的属性都可以被继承和隐藏而不能被重写，因此不能实现多态，不能实现父类的引用可以指向不同子类的对象。
 *    非静态方法可以被继承和重写，因此可以实现多态
 *
 */
public class Chapter5 {

    public static void main(String[] args) {

    }

}
