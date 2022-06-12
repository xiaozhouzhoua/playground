package com.some.playground.strings;

public class StringToInteger {
    public static void main(String[] args) {
        Integer some = Integer.parseInt("A", 16);
        Integer other = Integer.valueOf("A", 16);
        System.out.println(some);
        System.out.println(other);
        int a = Character.digit('A', 16);
        int b = Character.digit('A', 10);
        int c = Character.digit('9', 8);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
/* output
 * 10
 * 10
 * 10
 * -1
 * -1
 * */