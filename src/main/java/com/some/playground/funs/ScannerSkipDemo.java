package com.some.playground.funs;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerSkipDemo {
    public static void main(String[] args) {
        // 正则匹配
        String str = "Java scanner skip tutorial";
        Scanner sc = new Scanner(str);
        sc.skip(Pattern.compile(".ava\s"));
        System.out.println(sc.nextLine());

        // 或者使用字符串匹配
        String str2 = "Java scanner skip tutorial";
        Scanner sc2 = new Scanner(str);
        sc2.skip("Java ");
        System.out.println(sc2.nextLine());
    }
}
