package com.some.playground.enums;

import java.util.Random;

/**
 * Generate a Random Value From an Enum
 * <a href="https://www.baeldung.com/java-enum-random-value">生成随机枚举值</a>
 * <br/>
 * the values() method creates a copy of the enum values every time
 * the randomSession() method is called. We could improve the performance
 * by creating a final member variable list that we access after generating a random index
 */
public enum Season {
    WINTER, SPRING, SUMMER, FALL;
    private static final Random RANDOM = new Random();
    private static final Season[] sessions = values();
    public static Season randomSession() {
        return sessions[RANDOM.nextInt(sessions.length)];
    }

    public static void main(String[] args) {
        System.out.println(Season.randomSession().name());
    }
}
