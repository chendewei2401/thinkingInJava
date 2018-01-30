package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年1月10日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 对象导论:
 * 1，类描述了具有相同特性（数据元素）和行为（功能）的对象集合，所以一个类实际上就是一个数据类型
 * 2，使用现有类合成新的类叫组合（composition），组合是拥有的关系（has-a），比如汽车拥有引擎
 * 3，一个父类包含了其所有子类所共享的特性和行为。父类和子类之间是【是】（is-a）的关系,
 * 4，在建新类的时候，应该首先考虑组合，因为它更加灵活。
 *
 * OOP为什么会有多态
 * 1，一个非OOP语言的编译器产生的函数调用会引起所谓的【前期绑定】，即编译器将产生对一个
 *   具体函数名字的调用，而运行时将这个调用解析到将要执行代码的绝对地址（内存地址）上
 * 2，而OOP中，程序直到运行时才能够确认代码的地址。因此OOP语言使用了【后期绑定】的概念。即当对象发送消息时，
 *   被调用的代码直到运行时才能确认
 * 3，为了执行【后期绑定】，Java使用一小段特殊代码来代替绝对地址调用。这段代码使用在对象中存储的信息来计算方法体的地址。
 *   这样根据这一小段代码的内容，每个对象都可以具有不同的行为表现
 * 4，在某些语言里，必须明确的声明希望某个方法具备后期绑定属性所带来的灵活性（C++使用virtual关键字），在这些语言中，
 *   方法在默认情况下不是动态绑定的。而在Java中，动态绑定是默认行为
 *
 * 其他
 * 1，将子类转为父类是向上转型（upcasting），将父类转为子类是向下转型（downcasting）
 * 2，向下转型和运行时的检查需要额外的程序运行时间，Java里通过泛型进行优化。
 * 3，Java所有类都最终继承了单一的父类Object。单根继承结构保证了所有对象都具备某些功能。这样保证了所有对象都能执行
 *   某些基本操作，比如所有对象都很容易在堆上创建、简化了参数传递、垃圾回收实现简单，对于异常处理等系统级操作显得十分重要。
 * 4，异常提供了一种从错误状况进行可靠恢复的途径。
 *
 * 对象的创建与生命周期
 * 1，C++为了最求最大执行速度，对象的存储空间和生命周期在编写程序时确定，这可以通过将对象置于【栈（stack）】
 *   或静态存储区域（static storage area，应该就是vm stack）来实现。
 *   这种方式将存储空间分配和释放置于优先考虑的位置，在某些情况下很有必要，但牺牲了灵活性，因为在编写程序的时候就必须知道
 *   对象的确切数量、生命周期和类型。
 * 2，第二种方式就是在被称为【堆（heap）】的内存池中动态的创建对象。在这种方式中，直到运行时才知道对象的数量、生命周期和类型。即只有到
 *   程序运行时相关代码执行那一刻才能确定。
 *   如果需要一个新对象，可以在需要的那一刻直接在堆中创建
 * 3，因为存储空间是在运行时被动态管理的，所以需要大量时间在【堆】中分配存储空间，这可能要远远大于在【堆】中创建存储空间的时间。
 *   在【栈】中创建存储空间和释放存储空间通常各需要一条汇编指令即可，分别对应将栈顶指针向下移动和将栈顶指针向下移动。而创建【堆】存储空间
 *   的时间依赖于存储机制的设计。
 * 4，对于允许在【栈】上创建对象的语言，编译器可以确定对象的存活时间，并可以自动销毁它。然而如果是在【堆】上创建对象，编译器就会对他的生命周期一无所知。
 * 5，Java垃圾回收器被设计用来处理内存释放问题，这一点同所有对象都有同一父类Object、对象创建只能在堆上这一种方式结合起来，使Java编程障碍少很多。
 *
 * 堆和栈：
 * 1，Stack is thread specific and Heap is application specific. The stack is important to consider in exception handling
 *    and thread executions.
 *    @link http://www.net-informations.com/faq/net/stack-heap.htm
 * 并发：
 * 1，编程的一个基本概念，就是在同一时刻处理多个任务的思想。
 * 2，即程序能够停下正在做的工作，转而处理其他问题，然后再返回主进程。
 * 3，最初程序员用掌握的机器底层的知识来编写中断服务程序，主进程挂起是通过硬件中断来触发的。但这样难度高且不能移植。
 * 4，高级编程语言采用线程来实现并发。
 *
 *
 *
 */
public class Chapter1 {

    public void main(String[] args) {

    }

}
