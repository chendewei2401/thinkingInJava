package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年1月17日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 操作符:
 *
 * 1，前缀操作符（++a或--a）会先执行运算，再生成值。后缀操作符（a++或a--）相反，先赋值再执行运算。
 * 2，==比较的是对象的引用，而非对象的内容。Object的equal默认也是比较对象引用的，除非类自己做了覆盖。
 *   大多数Java类库都自己实现了equal方法，用来比较内容。
 * 3，如果在应该使用String的地方使用了boolean，boolean会自动转换为文本形式，即文本‘false’或者‘true’
 * 4，八进制由前缀0和其后0~7的数字组成。十六进制由前缀0x和其后0~9、a~f组成
 * 5，e代表10的幂次，如5e^8就等于5x10^8
 * 6，三元操作符类里的参数类型需要一致，否则会有类型转换错误
 * 7，如果表达式以字符串开头，则后续所有操作数都必须是字符串或者可以自动转换为字符串
 * 8，窄化转换可能面临信息丢失的危险，编译器会强制我们进行类型转换。扩展转换则不必显式进行类型转换
 * 9，float和double转为整型时，总是对该数字执行截尾。如果想得到舍入结果，需要使用java.lang.Math中的round()方法
 * 10，通常，表达式中出现的最大数据类型决定了最终结果的数据类型。
 *
 * 按位操作符
 * 1，与操作符（&）：只有两个输入位都是1时，结果才是1，否则都是0
 * 2，或操作符（|）：只有两个输入位都是0时，结果才是0，否则都是1
 * 3，异或操作符（^）：两个输入位，相同则结果为0，不同则结果为1
 * 4，非操作符（~）：取反操作。它属于一元操作符，只对一个操作数操作
 *
 * 移位操作符
 * 1，左移位操作符（<<）：操作数向左移动，低位补0
 * 2，右移位操作符（>>）：正数高位插0，负数高位插1
 * 3，右移位操作符（>>>）：无论正负，都高位插0
 *
 */
public class Chapter3 {

    public static void main(String[] args) {
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
        i <<= 2;
        System.out.println(Integer.toBinaryString(i));
        i >>>= 2;
        System.out.println(Integer.toBinaryString(i));


        int j = 1;
        System.out.println(Integer.toBinaryString(j));
        j <<= 2;
        System.out.println(Integer.toBinaryString(j));
        j >>= 2;
        System.out.println(Integer.toBinaryString(j));

    }

}
