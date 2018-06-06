package org.chen.book.thinkinginjava.practice;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {

    public String toString() {
        // StackOverflowError
        // 编译器自动把this转换为string，而这个转换是通过InfiniteRecursion对象的toString方法来实现的，因而出现了循环
        // 应该把this改为Object.toString()或者Super.toString()
        return "InfiniterRecursion Address : " + this  + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(new InfiniteRecursion());
        }

        for (InfiniteRecursion inf : list) {
            System.out.println(inf);
        }
    }

}
