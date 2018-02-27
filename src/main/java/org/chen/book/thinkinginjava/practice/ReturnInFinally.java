package org.chen.book.thinkinginjava.practice;

public class ReturnInFinally {
    public static void main(String[] args) {
        try {
            System.out.println("start");
            throw new NullPointerException();
        } catch (Exception e) {
            throw new NullPointerException();
        } finally {
            System.out.println("finally");
            return;
        }

    }
}
