package org.chen.book.thinkinginjava.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) throws Exception {

        Process pc = new ProcessBuilder("ipconfig").start();


        BufferedReader br = new BufferedReader(new InputStreamReader(pc.getInputStream(), "UTF-8"));

        String content;
        while ((content = br.readLine()) != null) {
            System.out.println(content);
        }


    }
}
