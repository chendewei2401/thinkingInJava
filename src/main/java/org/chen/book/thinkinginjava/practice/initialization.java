package org.chen.book.thinkinginjava.practice;

/**
 * 功能点：在类内部，变量定义的先后顺序决定了初始化的顺序，即使散布于方法之间，它们仍然会在任何方法被调用之前被初始化
 *
 */
public class initialization {
    public static void main(String[] args) {
        House h = new House();
        h.f();
    }
}

class Window {
    Window(int marker) {
        System.out.println("window:" + marker);
    }
}

class House {
    Window w1 = new Window(1);
    House() {
        System.out.println("house");
        Window w3 = new Window(33);
    }
    Window w2 = new Window(2);
    void f() {
        System.out.println("f()");
    }
    Window w3 = new Window(3);
}

