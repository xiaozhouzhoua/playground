package com.some.playground.funs;

public class IsPalindrome {
    public static void main(String[] args) {
        int x = 123321;
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        System.out.println(sb.reverse().toString().equals(String.valueOf(x)));
    }
}
