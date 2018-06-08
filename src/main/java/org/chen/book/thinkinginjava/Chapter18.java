package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年2月22日 下午1:34:02
 * @since JDK1.8
 * <p>
 * Java IO系统:
 * 1，对程序语言设计者来说，创建一个好的IO系统十分困难，挑战来自于要涵盖所有的可能性，不仅存在各种IO源端和想要与之通信的客接收端(文件、控制台、网络连接等)，
 *   还需要以多种方式与它们进行通信(顺序、随机存取、缓冲、二进制、按字符、按字节、按行等)。JDK1.0提供了字节流，JDK1.1提供了字符流,JDK1.4提供了nio
 * 2，File类：
 *   A，File类既可以代表一个文件，也可以代表一个目录，可使用list()方法获取该目录下的所有文件。
 *   B，可以使用FileNameFilter来对文件名称进行过滤
 *   C，还可以用File来创建还不存在的文件或目录
 *   D，renameTo()：可以把一个文件重命名为参数指定的新路径文件
 * 4，任何自InputStream或Reader派生而来的类都包含read()方法，用于读取单个字节或字节数组。同样任何自OutputStream或Writer派生而来的类都含有名为
 *   write()的方法，用于写单个字节或字节数组。这两个方法通常给别的类使用，包装成更方便的接口，这就是装饰器模式。Java IO库大量使用装饰器模式，这样
 *   创建单一的结果流就需要创建多个对象。
 * 5，InputStream类型：
 *   A，InputStream/Reader/InputStreamReader：
 *   A，ByteArrayInputStream/CharArrayReader：
 *   B，StringBufferInputStream/StringReader:
 *   C，FileInputStream/FileReader:
 *   D，PipedInputStream/PipedReader:
 *   E，SequenceInputStream:
 *   F，FilterInputStream/FilterReader:
 *   G，DataInputStream：
 *   H，BufferedInputStream
 * 6，OutputStream类型：
 *   A，OutputStream/Writer/OutputStreamWriter：
 *   A，ByteArrayOutputStream/CharArrayWriter：
 *   B，FileOutputStream/FileWriter:
 *   C，PipedOutputStream/PipedWriter:
 *   D，FilterOutputStream/FilterWriter:
 *   E，DataOutputStream：
 *   F，BufferedOutputStream
 *   G，PrintStream/PrintWriter：产生格式化输出，它自行捕捉了IOException
 *
 * 7，Java IO类库需要多种不同功能的组合，因此使用了装饰器模式，装饰器模式给我们提供了灵活性，可以很容易混合和匹配属性，但同时也增加了代码的复杂性
 * 8，InputStream和OutputStream在以面向字节形式的IO中提供了有价值的功能，Reader和Writer则提供了兼容Unicode和面向字符的IO功能
 * 9，有时候需要通过适配器把字节流和字符流结合起来使用，有时候不需要。java.util.zip类库就是面向字节的
 * 10，我们可以通过FilterInputStream或者FilterReader等装饰器子类来修改流以满足特殊需要
 * 11，RandomAccessFile适用于大小已知的文件，nio存储映射文件提供了类似功能
 * 12，new BufferedReader(new FileReader(fileName)).readline()中，当readline()方法返回空时，就达到了文件末尾
 * 13，标准IO的意义在于可以很容易把程序串联起来，使一个程序的标准输入变成另一个程序的标准输出
 *   A，Java提供了System.in、System.out和System.err三个标准IO
 *   B，System.out和System.err都是PrintStream对象，可以立即使用，而System.in是未经加工的InputStream，读取的话需要进行包装
 * 14，在Java内部执行程序：Process pro = new ProcessBuilder(Command.split(" .")).start()
 * 15，JDK1.4引入了NIO，旧IO是面向流的阻塞IO，NIO则是面向缓冲区的非阻塞IO：
 *   A，引入NIO目的在于提高速度，并且旧的io也已经用NIO重新实现过了，因此即使我们不用nio编写代码，也能从中受益。
 *   B，速度的提高在于nio所使用的结构更接近于操作系统执行IO的方式：通道和缓冲器。我们与缓冲器交互，而缓冲器与通道交互。如果通道是煤矿，则缓冲器是卡车，
 *     我们从卡车上获得煤。
 *   C，唯一直接与通道交互的缓冲器是ByteBuffer，它是可以存储未加工字节的缓冲器，是将数据移进移出通道的唯一方式。通道代表类是Channel
 *   D，FIleInputStream和FileOutputStream通过nio重新实现，用于产生FileChannel，它们是字节流，与nio底层性质一致。而Reader和Writer是字符流，
 *     不能产生通道，可以借助Channels类提供的实用方法
 *   E，视图缓冲器用指定数据类型对ByteBuffer进行包装，但数据还是存储在ByteBuffer里，比如通过intBuffer操作ByteBuffer里的int数据。
 *   F，byteBuffer中，缓冲器由数据和操纵这些数据的四个索引构成，包括mark、position、limit和capacity。
 * 16，内存映射文件(MappedByteBuffer)允许我们创建和修改那些太大而不能放到内存里的文件。通过MappedByteBuffer，我们可以假定整个文件放到了内存里，
 *   并把它当做数组来访问，会显著加快速度
 * 17，JDK1.4引入了文件加锁功能(FileLock)：
 *   A，Java的文件加锁直接映射到了本地操作系统的加锁工具，因此文件锁对其他的操作系统进程是可见的。
 *   B，FileChannel里提供了lock和tryLock两个方法。tryLock是非阻塞的，它设法获取锁，但如果不能获取则直接返回，而lock是阻塞式的，它会阻塞进程直到获得锁。
 * 18，对象序列化
 *   A，对象序列化加入到语言里主要是为了支持两种特性：一是RMI，它使存活于其他计算机上的对象使用起来就像存活于本机一样；再就是对Java Bean来说也需要序列化。
 *   B，Java的序列化是将那些实现了Serializable接口的对象转换成一个字节序列，并能够在以后将这个字节序列完全恢复为对象
 *   C，对象序列化是基于字节的，要序列化一个对象，使用ObjectOutputStream的writeObject即可，反序列化时调用ObjectInputStream的readObject方法，会生成
 *     一个Object引用，我们向下转型为原有类型即可。另外，如果我们在自己的类里添加(非覆盖)了具有相同签名的writeObject方法和readObject方法，
 *     序列化时会调用我们自己的方法
 *   D，对象序列化会跟踪对象内的所有引用，并序列化那些对象，接着又对这些对象内包含的每个引用进行追踪，以此类推。
 *   E，反序列化时必须保证JVM能找到相关的class文件
 *   F，Externalizable继承了Serializable接口，也可以实现序列化。同时提供了writeExternal和readExternal两个方法，在序列化过程中被自动调用，以
 *     执行一些特殊操作
 *   G，可以使用transition关键字关闭某个字段的序列化
 * 19，Preferences用于存储和读取配置信息等，它是一个类似映射的键值对，存储在一个节点层次结构中。它利用操作系统来存储信息，比如windows里利用注册表实现，因此是持久化的
 *
 *
 */
public class Chapter18 {

    public static void main(String[] args) {

    }

}
