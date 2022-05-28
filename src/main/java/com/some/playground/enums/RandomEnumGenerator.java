package com.some.playground.enums;

import java.util.Random;

/**
 * Random Enum Value with Generics
 *
 * Class.getEnumConstants() 返回枚举类的元素，或null 如果此Class对象不表示枚举类型。
 */
public class RandomEnumGenerator<T extends Enum<T>>  {
    private static final Random RANDOM = new Random();
    private final T[] values;

    public RandomEnumGenerator(Class<T> enumType) {
        this.values = enumType.getEnumConstants();
    }

    public T randomEnum() {
        return values[RANDOM.nextInt(values.length)];
    }

    public static void main(String[] args) {
        RandomEnumGenerator<Season> reg = new RandomEnumGenerator<>(Season.class);
        Season season = reg.randomEnum();
        System.out.println(season.name());
    }
}
