package org.chen.book.thinkinginjava.practice;

/**
 * 功能点：继承时初始化顺序：
 *    A，调用父类构造器。反复递归到最底层的父类，从最底层的父类开始，先初始化成员变量，然后调用构造器
 *    B，一级级处理，直到最终的子类
 */
class Meal {
    Meal() {
        System.out.println("meal()");
    }
}

class Bread {
    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    Cheese() {
        System.out.println("cheese");
    }
}

class Lettuce {
    Lettuce() {
        System.out.println("lettuce()");
    }
}

class Lunch extends Meal {
    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}

public class SandWich extends PortableLunch {
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    public static void main(String[] args) {
        new SandWich();
    }
}
