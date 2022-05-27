package com.some.playground.funs;

public class SwapDemo {
    public static void main(String[] args) {
        int a = 5, b= 10;
        a = a ^ b ^ (b = a);

        System.out.println(a);
        System.out.println(b);
    }
}
