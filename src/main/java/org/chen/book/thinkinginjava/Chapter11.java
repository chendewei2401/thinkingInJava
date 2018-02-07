package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年2月5日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 持有对象:
 * 1，数组具有固定尺寸，是保存一组对象的最有效的方式。如果想保存一组基本类型，也推荐使用数组。
 * 2，Java容器类都可以自动调整大小。容器只能存储对象，不能存储基本类型，基本类型会被自动装箱为包装类型
 * 3，在容器中使用泛型，可以在编译期间就防止将错误类型的对象放置到容器中
 * 4，Java容器的用途就是保存对象。一般包括Collection和Map两种
 * 5，Collection是一个独立元素的序列，这些元素都服从一条或多条规则。List按插入的顺序保存元素、Set不能有重复元素，而Queue
 *   按排队规则来确认对象产生的顺序（通常与它们被插入的顺序相同）
 * 6，Map是一组键值对，可以通过键来查找值。
 * 7，一般通过向上转型来解耦对象与实现，比如List<Apple> list = new LinkedList<>()。但并非总能奏效，因为子类一般具有额外的功能，
 *   比如LinkedList和TreeMap都有List和Map未包含的功能，向上转型为通用接口后就不能再使用这些功能
 * 8，容器都实现了默认的toString功能，因此可直接输出对象内容
 * 9，List以特定顺序保存一组元素、Set元素不能重复、Queue只允许在容器的一端插入对象，并从另一端移除对象，
 * 10，HashSet没有顺序，但存取速度最快（使用散列函数），TreeSet按比较结果的升序保存对象（使用红黑树数据结构），LinkedHashSet按被添加的顺序保存对象
 * 11，HashMap提供了最快的查找速度，TreeMap按比较结果的升序保存对象，LinkedHashMap按插入顺序保存键，同时还保留了HashMap的查询速度
 * 12，ArrayList长于随机访问元素，但插入和移除元素较慢。LinkedList正好相反
 * 13，容器里的contain等操作会根据equal行为而有所变化，比如如果容器里保存了String，String内容一致contain即返回true，但对象的话引用必须一致才行
 * 14，LinkedList实现了List、queue，添加了可以使其用作栈(addFirst、removeFirst等)、队列、双端队列的方法
 * 15，栈：Stack，后进先出(LIFO)，最后压入栈的元素，第一个弹出栈，如同自助餐托盘。
 * 16，队列：Queue，先进先出(FIFO)，即从容器一端放入元素，从另一端取出元素，取出顺序与放入顺序一致。
 * 17，Map可以返回他的键的KeySet、值的Collection（values()），或它的键值对的EntrySet
 * 18，程序中建议不要使用过时的Vector、HashTable、Stack
 * 19，标记接口java.util.RandomAccess附着到了ArrayList上
 * 20，其实只有四种容器：Map、Set、List和Queue，它们各有两到三个实现版本
 *
 * 容器API：
 * 1，Arrays和Collections是数组和容器的工具类
 * 2，Arrays.asList()方法接受一个数组或者用逗号分隔的可变元素列表，将其转换为list对象，但该List对象其实是
 *   java.util.arrays.ArrayList对象，底层为数组实现，如果对该对象进行delete或者add，会抛出异常
 * 3，Collections.addAll()方法将一个数组或者用逗号分隔的可变元素列表，添加到一个Collection对象中
 * 4，Collection的addAll()方法可将两个容器对象合并
 * 5，retainAll()方法用来去交集操作
 * 6，clear()方法用来清除容器内内容
 * 7，
 *
 * 迭代器：
 * 1，迭代器用来遍历并选择Collection中的对象，而不必关系Collection的底层实现结构。
 * 2，Java容器的迭代器创建代价小，统一了对容器的访问方式，但只能单向移动
 * 3，迭代器使用方式
 *   3.1 使用iterator方法要求容器返回一个Iterator，Iterator将准备好返回容器的第一个元素
 *   3.2 使用next获取容器中的下一个元素
 *   3.3 使用hasNext检查容器中是否还有下一个元素
 *   3.4 使用remove将迭代器新近返回的元素删除。即，remove移除next产生的下一个元素，因此调用remove前必须调用next
 * 4，ListIterator是一个专门处理List访问的迭代器，可双向移动
 * 5，Collection实现了Iterator，因此实现Collection时就需要提供iterator方法
 *
 * 队列：
 * 1，队列queue提供了offer、peek、poll等方法
 * 2，offer将一个元素插入到队尾
 * 3，peek和element都可以在不移除的情况下返回队头，为空情况peek返回null、而element返回Exception
 * 4，poll和remove都可以移除并返回队头，为空时poll返回null，remove返回Exception
 * 5，普通队列中，下一个元素就是等待时间最长的元素
 * 6，优先级队列PriorityQueue中，下一个元素是最需要的元素，即有最高优先级的元素。
 * 7，当使用PriorityQueue的offer方法插入一个对象时，插入元素在队列中被排序，默认使用自然顺序，可自定义Comparator修改顺序
 * 8，PriorityQueue的peek、poll等方法返回的元素是队列中优先级最高的元素
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class Chapter11 {

    public static void main(String[] args) {

    }

}
