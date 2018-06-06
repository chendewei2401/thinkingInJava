package org.chen.book.thinkinginjava.practice;

import java.util.Random;

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        // 通过.class获得class引用时不会触发该class的初始化
        Class initable = Initable.class;
        System.out.println("After creating initable ref");
        // static final编译期常量直接访问不触发初始化
        System.out.println(Initable.staticFinal);
        // Does trigger initialization
        System.out.println(Initable.staticFinal2);
        // Does trigger initialization
        System.out.println(Initable2.staticNonFinal);
        // Class.forName会触发初始化
        Class initable3 = Class.forName("org.chen.book.thinkinginjava.practice.Initable3");
        System.out.println("After creating initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }

}
