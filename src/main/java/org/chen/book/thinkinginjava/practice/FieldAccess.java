package org.chen.book.thinkinginjava.practice;

/**
 * 功能点：继承与初始化
 *  只有方法调用是多态的，变量的访问在编译器进行解析，不是多态的。因此如果想访问运行时绑定类的变量，需要显示指定
 */
class Super {
    public int field = 0;
    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;
    public int getField() {
        return field;
    }
    public int getSuperField() {
        return super.field;
    }
}

public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();
        // 只有方法调用是多态的，变量的访问在编译器进行解析，不是多态的。因此如果想访问运行时绑定类的变量，需要显示指定
        System.out.println(sup.field + "##" + sup.getField());

        Sub sub = new Sub();
        System.out.println(sub.field + "##" + sub.getField() + "##" + sub.getSuperField());
    }
}
