package org.chen.book.thinkinginjava;

/**
 * @author chendewei2401@gmail.com
 * @version V1.0
 * @date 2018年2月22日 下午1:34:02
 * @since JDK1.8
 * <p>
 * 数组:
 * 1，数组是一种效率最高的存储和随机访问对象引用序列的方式，但为这种速度所付出的代价是数组大小被固定
 * 2，数组可以持有基本类型
 * 3，length是数组的大小，而不是实际保存的元素个数。新生成一个数组对象时，其中所有的引用被初始化为null。基本类型数组里，
 *   数值型被初始化为0，布尔型为false，字符型为空
 * 4，数组操作类为Arrays，常用方法有toString()、deepToString()、equal()比较两个数组、deepEqual()比较两个多维数组、sort()、
 *   binarySearch()已经排好序的数组执行快速查找。
 * 5，使用System.arraycopy()复制数组比for循环要快很多
 * 6，String排序算法根据字典顺序，大写字母开头的词放在前面
 * 7，应该优选容器而非数组。只有在性能成为瓶颈，且切换到数组对性能有帮助的情况下，才使用数组重构
 * 8，Math.random()的输出范围为[0,1)
 *
 */
public class Chapter16 {

    public static void main(String[] args) {

    }

}
