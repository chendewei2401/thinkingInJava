package org.chen.book.thinkinginjava.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {

        // Try/Catch没有起到作用
        try {
            ExecutorService es = Executors.newCachedThreadPool();
            es.execute(new ExceptionThread());
        } catch (Exception e) {
            System.out.println("Exception Handled");
        }
    }
}
