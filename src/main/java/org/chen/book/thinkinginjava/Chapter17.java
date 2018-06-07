package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年2月22日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 容器深入研究:
 * 1，Object.toString()：输出该类的名字，后面紧跟该对象的散列码的无符号十六进制表示（通过hashCode()生成）
 * 2，动态语言可以在任何对象上调用任何方法，并且可以在运行时发现某个特定调用是否可以工作
 * 3，Arrays.asList()会生成一个List，它基于一个固定大小的数组，仅支持那些不会改变数组大小的操作，
 *   任何会引起底层数据结构的尺寸进行修改的方法都会产生一个UnsupportedOperationException异常。
 *   另，把Arrays.asList()的结果作为构造器参数传递给任何Collection，可以生成允许使用所有方法的普通容器
 * 4，Arrays.asList()返回固定尺寸的List，可以修改其中元素，只要不违反其“尺寸固定”特性即可。Collections.unmodifiableList()产生不可修改的列表
 * 5，return i-j：这是个常见编程错误，只有在i和j都是无符号的int才能正常工作。如果j是很大的负数，i-j就可能会溢出并且返回负值
 * 6，双向队列（双端队列）就像是一个队列，但可以在任何一端添加或移除元素，接口为Deque，LinkedList实现了Deque功能
 * 7，Collections方法：
 *   fill()：只能替换已经在List中的元素，而不能添加新的元素
 *   copy(dest, src)：将src里的元素复制到dest
 *   max(Collection)：返回集合里的最大元素
 *   min(Collection)：返回集合里的最小元素
 *   disjoint(Collection, Collection)：当两个集合没有共同元素时，返回true
 *   frequency(Collection, object)：返回集合汇总等于object的元素个数
 *   emptyList()、emptySet()、emptyMap()：返回不可变的空集合
 * 8，TreeMap是经过排序的，且是唯一带有subMap()方法的Map，可以返回子树。TreeMap还是SortedMap的唯一实现。TreeSet基于TreeMap。
 * 9，hashCode是用以代表对象的int值，它通过将该对象的某些信息进行转换而生成，相对唯一，因此能代表一个对象，但可能出现哈希冲突。hashCode()是根类Object
 *   中的方法，因此所有方法都能产生hashCode
 * 10，Map里任何键都必须有一个equals()方法，如果键被用于HashMap，那它必须还要有合适的hashCode()方法，如果键被用于TreeMap，那他必须实现Comparable。
 *   因此覆盖equal()方法时总是同时覆盖hashCode()能比较好的避免问题。
 * 11，散列的价值在于速度。
 *   A，它将键保存在某处，以便能够很快找到，存储一组元素最快的数据结构是数组，所以用它来表示键的信息。
 *   B，数组并不保存键本身，而是通过键对象生成器HashCode，将其作为数组下标，而数组保存值的list（因为冲突可能导致该下标对应多个值）
 *   C，数组大小固定，而我们希望Map中能保存不定数量的值。为了解决数据大小固定带来的问题，HashMap使不同的键可以产生相同的下标，
 *     也就是说hashCode可能会有冲突。这样数组多大就不重要了，因为任何键总能在数组中找到它的位置
 *   D，如果键值对的数量是固定的，则有可能保证键的hashCode没有冲突，这就是一个完美的哈希函数。EnumMap和EnumSet就实现了完美的哈希函数，
 *     因为enum定义了固定数量的实例
 *   E，查询一个值的过程首先是计算键的hashCode，然后使用hashCode查询数组，获取数组保存的值list，然后对list的值通过equals进行线性查询。
 *   F，线性查询部分比较慢，但如果散列函数好的话，数组的每个位置只有较少的值，可以只对很少元素进行比较，这就是HashMap如此快的原因。
 *   G，为了是HashCode分布均匀，数组大小通常使用2的整数次方（2的幂次）。因为对现代CPU来说，除法和求余数是最慢的操作，使用2的幂次长度的散列表，
 *     可以用位运算代替除法。因为get()是使用最多的操作，求余数的%是开销最大的部分，而使用2的幂次可以消除此开销。
 *   H，设计hashCode函数需要注意保证对同一个对象调用hashCode()函数必须生成相同的值；另外，应该更关心其生成速度而非唯一性，通过hashCode和equals
 *     必须能够完全确定对象的身份
 * 12，HashMap的性能因子：我们可以通过手工调整HashMap来提高其在我们特定应用里的性能，HashMap和HashSet都有允许指定初始容量和负载因子的构造器
 *   A，容量capacity：表的桶位数，即数组大小，因为2的幂次
 *   B，初始容量：表在创建时设置的容量，HashMap为16
 *   C，大小size：表中当前存储的元素个数
 *   D，负载因子：当负载情况到达该负载因子水平时，容器将自动增加其容量，实现方式为使容量大致加倍，并将现有对象重新分配到新的桶集中（即再散列）。
 *     负载因子需要在时间和空间代价之间达到平衡，更高的负载因子可以降低表所需的空间，但会增加查找代价，而Map最常用的操作是查找。
 * 13，容器之间的区别通常归结于背后支持它们的数据结构。
 * 14，除了IdentityMap外，所有的Map插入操作都会随着Map变大而明显变慢，但查找代价通常比插入要小的多。而一般来说查找操作要比插入操作多很多。
 * 15，快速报错：Java容器采用快速报错机制来防止多个进程同时修改同一容器的内容。它会探查容器上任何除了你的进程操作以外的所有变化，一旦发现
 *   其他进程修改了容器，立刻抛出ConcurrentModificationException
 * 16，持有引用：java.lang.ref类库包含了一组类，为垃圾回收提供了更大的灵活性
 *   A，如果想继续持有对某个对象的引用，希望以后还能访问到该对象，但也希望能够允许垃圾回收器释放它，就应该使用Reference对象。这样你可以继续使用
 *     该对象，而在内存耗尽时又允许释放该对象
 *   B，通过Reference包装对象并提供引用即可。该对象不能有未经过reference包装的普通引用，否则不会被释放
 *   C，SoftReference、WeakReference和PhantomReference都继承自Reference抽象类，这些派生类为gc提供了不同级别的间接性指示，可回收性从弱到强
 * 17，Vector、Enumeration和Stack是容器里比较失败的设计，Stack不是用Vector来构建，而是继承，这不合理。我们应该避免使用Stack，如果需要栈的行为，
 *   可以使用LinkedList
 * 18，BitSet：BitSet在空间上可以高效的存储大量开关信息，在时间上BitSet比本地数组稍慢。使用BitSet而非EnumSet的理由只包括：
 *   在运行时才知道需要多少个标志；对标志命名不合理；需要BitSet某个特殊操作
 */
public class Chapter17 {

    public static void main(String[] args) {

    }

}
