package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年2月22日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 并发:
 * 1，并发编程令人困惑的主要原因是：使用并发时需要解决的问题有多个，而实现并发的方式也有多种，且两者之间没有明显的映射关系，因此
 *   需要理解所有这些问题和特例，以便有效的使用并发
 * 2，用并发解决的问题大体可分为速度和设计可管理性两种
 * 3，并发通常是提高运行在单处理器上的程序的性能。
 *   A，这听起来有些违背直觉，在单处理器上运行的并发程序，因为涉及到上下文切换，开销应该比所有程序都顺序执行大。
 *   B，但如果程序里的某个任务因为程序控制之外的某些条件(通常为IO)而导致不能继续执行，即该任务或线程被阻塞了，如果没有并发，则整个程序都将停止，直到外部条件发生变化。
 *   C，如果使用并发来编写程序，那么当一个任务阻塞时，程序中的其他任务还可以继续执行，因此这个程序可以保持继续向前执行
 *   D，事实上，从性能的角度看，如果没有任务会阻塞，在单处理器机器上使用并发就没有任何意义
 * 4，实现并发最直接的方式是在操作系统级别使用进程
 *   A，进程是运行在自己地址空间内的自包容程序
 *   B，多任务操作系统可以通过周期性地将CPU从一个进程切换到另一个进程，来实现同时运行多个进程(程序)
 *   C，操作系统将进程自动隔离，是它们不会相互影响，这使得进程编程相对容易
 *   D，Java进程里的并发系统会共享内存和IO等资源，因此编写多线程程序最基本的困难在于，协调不同线程驱动的任务对资源的使用，以使这些资源不会同时被多个任务访问
 * 5，函数型语言被设计为可以将并发任务彼此隔离，每个函数调用都不会产生副作用，因此可以当作独立的任务，比如Erlang语言，如果程序中需要大量使用并发，可以使用这种函数式编程语言
 * 6，在单CPU上使用多任务的程序在任意时刻仍旧只在执行一项工作
 * 7，多线程机制分为协作式和抢占式。
 *   A，Java线程机制是抢占式的，这表示调度机制会周期性的中断线程，将上下文切换为另一个线程。
 *   B，协作式系统中，每个任务都会自动放弃控制，这要求程序员有意识的在每个任务中插入某种类型的让步语句
 *   C，协作式系统上下文切换的开销比抢占式的低，并且同时执行的线程数量理论上没有限制，但容易使单个线程独占导致不公平
 * 8，并发需要付出代价，包含复杂性代价，但这些代价与在程序设计、资源负载均衡以及用户方便使用方面的改进相比，就显得微不足道。
 * 9，通常线程还使你能够创建更加松散非耦合的设计，否则，代码中各个部分都要显式的关注那些通常可以由线程来处理的任务。
 * 10，如果程序运行的太慢，为机器增添一个CPU就能很容易的加快程序的运行速度。多任务多线程往往是使用多CPU系统的最有效方式。同时，线程机制使代码不必知道
 *   它是运行在一个还是多个CPU机器上。所以使用线程机制是一种建立透明、可扩展程序的方法。
 * 11，线程实现：
 *   A，可以实现Runnable的run方法，或者继承Thread的run方法即可；线程启动使用Thread的start方法
 *   B，如果在run中调用静态方法Thread.yield()，则表示对线程调度器指示可以进行上下文切换了，这完全是选择性的
 *   C，调用main()方法会启动主线程
 *   D，Thread实现了Runnable接口，它的的start方法为该线程执行必须的初始化操作，继承自接口的run方法在该线程中启动了任务
 *   E，每个Thread都有一个对它的引用，在它的任务退出run方法并死亡前，gc无法回收
 *   F，一个线程会创建一个单独的执行线程，在对start的调用完成后，它仍然会存在
 *   G，如果某个线程在另外一个线程t上调用t.join()，该线程将被挂起，直到目标线程t结束才恢复(即t.isAlive()返回false)。
 * 12，concurrent包里的执行器Executor可以管理线程对象，从而简化并发编程。
 *   ExecutorService es = Executor.newCachedThreadPool();
 *   for (int i = 0; i < 5; i++) {
 *       es.execute(thread);
 *   }
 *   es.shutdown();
 *   A，Executor允许你管理异步任务的执行，而无需显式的管理线程的生命周期
 *   B，调用shutdown可以防止新任务被提交给这个Executor，当前main线程将继续运行shutdown调用之前提交的任务
 *   C，这个程序将在Executor中所有任务完成之后尽快退出
 *   D，CachedThreadPool：重用可用线程，如果不存在可用线程，那么会重新创建一个新的线程并将其加入到线程池中。
 *     如果线程超过60秒还未被使用，就会被中止并从缓存中移除。因此，是Executor的首选
 *   E，FixedThreadPool：使用固定数量的线程集来执行所提交的任务
 *   F，SingleThreadPool：是线程数量为1的FixedThreadPool，可以连续运行长期存活的任务，如果提交了多个任务，则会排队等待
 *   G，ScheduledThreadPoolExecutor：可以将线程设置为在将来某个时刻执行
 * 13，Runnable是执行工作的独立任务，不返回任何值。如果希望任务完成后能返回结果，可使用Callable。Callable是JDK5引入的具有类型参数的泛型，
 *   使用具有返回值的call方法代替run方法，需要使用ExecutorService的submit方法调用：
 *     ExecutorService es = Executor.newCachedThreadPool();
 *     List result = new ArrayList<Future<String>>();
 *     for (int i = 0; i < 5; i++) {
 *        result.add(es.submit(callable))
 *     }
 *     for (Future<String> fs : result) {
 *        System.out.println(fs.get());
 *     }
 *   A，submit方法返回Future对象，Future对象有cancel()、isDone()、get()等方法
 *   B，get如果任务没有完成会一直阻塞，知道任务完成或者超时
 * 14，使用旧的Thread.sleep(100)或者新的TimeUnit.MILLISECONDS.sleep(100)使任务终止给定的时间
 * 15，线程中的异常：
 *   A，异常不能跨线程传播给main线程，即使main里对线程用了try/catch也无法捕获。因此需要在本地处理所有在任务内部产生的线程
 *   B，可以使用Thread.UncaughtExceptionHandler接口为每个Thread对象附着一个异常处理器
 * 16，线程优先级：
 *   A，线程优先级将该线程的重要性传递给调度器，调度器倾向于让优先级最高的线程先执行
 *   B，优先级较低的线程仅仅是执行的频率较低
 *   C，绝大多数情况线程都以默认优先级运行，操纵线程优先级通常是一种错误
 *   D，使用Thread.currentThread().setPriority(xx)来设置线程优先级
 *   E，JDK线程有10个优先级，但与操作系统线程优先级映射不好，因此一般只使用MIN_PRIORITY、NORM_PRIORITY和MAX_PRIORITY
 *   F，setDaemon()方法将线程设置为后台线程，需要在线程启动前调用
 * 17，要执行的任务和驱动它的线程是不一样的。我们创建任务，并通过某种方式将一个线程附着到任务上，以使这个线程可以驱动任务。
 * 18，创建线程代价高昂，因为必须保持和管理它们。从实现角度来看，将任务和线程分离是有意义的。另外，Java的线程机制来自于c的低级的p线程方式
 * 19，“最好把线程组看成一次不成功的尝试，忽略它就好” - Joshua Bloch
 * 20，通过锁解决共享资源竞争：
 *   A，基本上所有并发模型在解决线程冲突时，都采用序列化访问共享资源的方式，即在给定的时刻只允许一个任务访问共享资源。
 *   B，通常这是通过在代码里加锁语句来实现，这样就会使在一段时间内只有一个任务可以运行这段代码。
 *   C，因为锁语句产生了一种相互排斥的效果，所以这种机制常常成为互斥量mutex
 *   D，Java通过关键字synchronized加锁，当任务要执行被synchronized关键字保护的代码段时，它将检查锁是否可用，然后获取锁，执行代码，释放锁。
 *   E，JVM负责追踪对象被加锁的次数。在任务第一次给对象加锁时，计数变为1，每当相同对象被加锁，计数加一，锁离开则计数减一。当计数为0锁被释放
 * 21，synchronized关键字：
 *   A，synchronized(this)修饰代码块时，作用范围是该代码块，加锁对象是括号内指定的对象this
 *   B，synchronized修饰方法时，作用范围是该方法，加锁对象是调用该方法的对象，该类的其他实例不受影响
 *   C，synchronized修饰静态方法时，作用范围是该方法，加锁对象是这个类的所有对象
 *   D，synchronized修饰类时，作用范围是该类，加锁对象是这个类的所有对象
 *   E，当一个线程访问对象的一个synchronized代码时，另一个线程仍然可以访问该对象中的非synchronized代码
 *   F，使用同步代码块而非对整个方法加锁，可以使多个任务访问对象的时间性能得到显著提高
 * 21，java.util.concurrent.locks：
 *   A，与内建锁synchronized相比，Lock是显式锁机制。Lock对象必须被显式的创建、锁定和释放，代码更加灵活，但缺乏优雅。
 *     从性能角度考虑的话我们应该只互斥那些需要互斥的代码部分，因此Lock通常要比synchronized高效。
 *   B，Lock对象包括lock、tryLock和unlock三个方法
 *   C，应该把unlock方法放在finally子句中，并在try里做return，这样确保unlock不会过早发生，将数据暴露给第二个任务
 *   D，使用synchronized加锁代码量，错误出现的可能性也降低，因此通常只有在解决特殊问题时，才使用lock对象
 *   E，ReentrantLock为重入锁，实现了Lock，它拥有与synchronized相同的并发性和语义，但功能更全面，比如trylock、lockInterruptibly等。
 *     它有一个与锁相关的获取计数器，如果拥有锁的某个线程再次得到锁，那么获取计数器就加1，然后锁需要被释放两次才能获得真正释放。
 *   F，ReadWriteLock为读写锁，在读的时候，上读锁，在写的时候，上写锁，这样就很巧妙的解决synchronized的一个性能问题：读与读之间互斥，但ReadWriteLock
 *     是否能提高性能取决于读取和写入频率比较
 * 22，可视性：
 *  A，相比单CPU系统，多CPU系统上可视性问题远比原子性问题多。一个线程做的修改，即使是原子性的，也可能对其他线程不可视，因为修改可能只是暂存在了本地CPU缓存中
 *  B，同步机制强制一个线程做的修改在应用中是可视的。
 *  C，volatile关键字也能确保应用中的可视性。如果将一个域声明为volatile，则只要对该域做了修改，所有读操作任务会立刻可见，即使用了缓存
 *    因为volatile域会被立刻写入主存，而读操作就发生在主存里
 *  D，同步也会导致向主存中刷新，因此如果一个域已经由synchronized保护，就可以不用volatile
 *  E，最优先的选择是synchronized，只有在类中只有一个可变域时，才考虑使用volatile
 * 23，Atomic类：AtomicInteger的incrementAndGet方法用来更新并返回更新后的值，是原子操作。只有一个需要被修改的Atomic对象，且该对象独立于其他对象时才用Atomic类
 * 24，java.lang.ThreadLocal类：线程本地存储类，为使用相同变量的每个不同线程都创建不同存储副本。使用get和set方法访问对象的内容。
 * 25，线程状态：一个线程可能处于一下五种状态
 *   A，新建new：当线程被创建后会短暂处于该状态，此时线程已经被分配了资源并执行了初始化，已经有资格获得CPU时间了。之后调度器将该线程转为runnable或blocked状态
 *   B，就绪runnable：线程对象新建后，调用start方法进入runnable状态。只要调度器把时间片分配给该线程就进入运行状态，否则就一直处于就绪状态
 *   C，运行running：线程获得了CPU时间片，并执行代码
 *   D，阻塞blocked：某个条件阻止了线程的运行。调度器忽略处于阻塞状态的线程，直到该线程重新进入就绪状态。
 *   E，死亡dead：线程run()、main() 方法执行结束，或者因异常退出了run()方法，则该线程结束生命周期，不可被调度。
 * 26，一个任务进入阻塞状态，可能有如下原因：
 *   A，调用sleep方法使任务进入休眠状态，此时该线程继续持有锁，不会释放。休眠时间过后线程进入就绪还是运行状态取决于操作系统，JVM没有指定
 *   B，调用await挂起线程，此时会释放锁，并进入阻塞状态，直到线程得到notify()或notifyAll()消息(或者concurrent中等价的signal或signalAll)重新进入runnable状态
 *   C，等待某个输入输出完成
 *   D，任务试图在某个对象上调用其同步代码，但该对象锁已被其他任务获得，则该任务进入阻塞
 * 27，较早代码可能使用suspend()或resume()来阻塞和唤起线程，现在已经废弃，因为可能导致死锁。stop()方法也被废弃，因为它不释放线程获得的锁。
 * 28，中断在java中主要有3个方法，interrupt()、isInterrupted()和interrupted()：
 *   A，interrupt()：在一个线程中调用另一个线程的interrupt()方法，即会向那个线程发出信号。它不能中断在运行中的线程，只能改变中断状态而已，是否中断由
 *     这个thread的具体实现代码来决定
 *   B，isInterrupted()：用来判断当前线程的中断状态(true or false)
 *   C，interrupted()：是Thread的static方法，用来恢复中断状态(?)
 *   D，在Executor上调用shutdownNow()会发送一个interrupt给它启动的所有线程
 *   E，只要任务以不可中断的方式被阻塞，就有可能会锁住程序，出现死锁。
 * 29，线程协作：
 *   A，线程通过Object的wait和notify进行协作，Java5还引入了具有await和signal方法的更安全的Condition对象，wait和await功能相似，notify和signal也相似
 *   B，wait方法有两个，调用带毫秒参数的线程到时间后会自动恢复，没有参数的wait会无限期等待，除非接收到notify或notifyAll
 *   C，notify和notifyAll都达到相同的效果，都只会有一个线程继续运行。但notifyAll免去了线程运行完了通知其他线程的必要，因为已经通知过了。但使用notify
 *     而非notifyAll可能更好，因为本来就只需要唤醒一个线程的。
 *   D，只能在同步块里使用wait、notify和notifyAll方法，在非同步块里调用的话，编译没有问题，运行时抛出illegalMonitorStatusException
 *   E，所以如果要向对象x发送notify，那么就必须在能够取得x同步控制块中：synchronized(x){x.notify();}
 * 30，生产者消费者与队列：
 *   A，wait和notify通过每次交互都握手的低级方式解决了线程协作问题
 *   B，同步队列在更高的抽象级别上解决线程协作问题，它在任意时刻都只允许一个任务插入或移除元素
 *   C，java.util.concurrent.BlockingQueue接口提供了同步队列，实现包括具有固定尺寸的ArrayBlockingQueue，基于链表的LinkedBlockingQueue，
 *     基于优先级的PriorityBlockingQueue，还有对元素进行持有直到一个特定的延迟时间才允许取走的DelayQueue。
 *   D，如果消费者任务试图从空阻塞队列获取对象，该队列会挂起消费者任务，直到队列从生产者任务获得对象后再恢复消费者队列。阻塞队列比wait和notify简单可靠
 * 31，Java对死锁没有提供语言层面的支持，需要通过仔细的设计程序来避免
 * 32，concurrent库其他类：
 *   A，CountDownLatch:可以实现类似计数器的功能。比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 *     参考CountDownLatchSample.java
 *   B，CyclicBarrier：通过它可以实现让一组线程等待至某个状态之后再全部同时执行
 *   C，Semaphore：正常的锁(lock或synchronized)在任何时刻都只允许一个任务访问一项资源，而计数信号量(Semaphore)允许n个任务同时访问某个资源
 *   D，Exchanger：用来交换两个线程之间持有的对象
 * 33，concurrent库中的免锁容器：
 *   A，免锁容器的通用策略是：同时对容器读和写。写操作是在容器数据结构的某个部分的单独副本进行，且这个副本在写过程中是不可见的。当修改完成，被修改的数据结构
 *     才会自动与主数据结构进行交换，之后读取者就可以看到这个修改了。
 *   B，CopyOnWriteArrayList写操作会拷贝整个底层数组，CopyOnWriteArraySet基于CopyOnWriteArrayList实现。ConcurrentHashMap和ConcurrentLinkedQueue
 *     写时只拷贝部分内容。写时读操作都不抛出ConcurrentModificationException异常
 *   C，乐观锁假定不会发生并发冲突，只在提交操作时检查是否违反数据完整性，比如AtomicInteger里的compareAndSet实现
 *   D，悲观锁假定会发生并发冲突，屏蔽一切可能违反数据完整性的操作
 *
 */
public class Chapter21 {

    public static void main(String[] args) {

    }

}
