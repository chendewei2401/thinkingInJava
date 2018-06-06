package org.chen.book.thinkinginjava.practice;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
    public static void main(String[] args) {
        String regex = "0\\d{2}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("0ab");
        boolean result = matcher.matches();
        System.out.println(result);

        result = Pattern.matches(regex, "0ab");
        System.out.println(result);

        String[] splitStrs = pattern.split("023?023*4560456");//123 123 456 456
        System.out.println(Arrays.toString(splitStrs));
    }
}
