package org.chen.practice;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年1月17日 下午1:34:02
 * @since JDK1.8
 * @link https://docs.oracle.com/javase/9/tools/
 * <p>
 * Java 代码review checklist
 *
 *
 * 1，日志统一使用slf4j，有字符串拼接使用parameterized logging模式
 * 2，String拼接使用StringBuilder
 * 3，时间应该使用java8 api，不要用SimpleDateFormat，可使用apache DateFormatUtils.format DateFormatUtils.format替代
 * 4，如果不加锁最好就不要加，即优先使用arraylist、hashmap，而非vector、hashtable、concurrentHashMap等
 * 5，将工具函数标识为final、JDK 在运行一定次数后，JIT 有可能将此 final 类型的函数内联？====
 * 6，反射中，尽可能缓存 Method 对象，获取 Method 对象是反射调用最消耗性能的地方。
 * 7，计数器使用AtomicInteger，而不要用synchronize
 * 8，正则表达式只是更为灵活，但在特定场景下性能不一定最优
 * 9，数组拷贝，尽量用System.arraycopy()，而不要自己写循环
 *
 *
 *
 *
 */
public class JavaCodeView {


    public static void main(String[] args) {

    }

}
