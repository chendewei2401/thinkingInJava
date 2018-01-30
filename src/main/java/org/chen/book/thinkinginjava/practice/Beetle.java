package org.chen.book.thinkinginjava.practice;

/**
 * 功能点：继承与初始化
 *
 */

class Insect {
    private int i = 9;
    protected int j;
    Insect() {
        System.out.println("i=" + i + "j=" + j);
        j = 39;
    }
    public static int x1 = printInt("insect static x1 init");
    static int printInt(String s) {
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect {
    private int k = printInt("beetle init");
    public Beetle() {
        System.out.println("k=" +k);
        System.out.println("j=" +j);
    }

    public static int x2 = printInt("beetle static x2 init");

    public static void main(String[] args) {
        System.out.println("bettle main");
        Beetle b = new Beetle();
    }
}
