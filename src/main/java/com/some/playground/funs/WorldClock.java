package com.some.playground.funs;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

/**
 * entry("CTT", "Asia/Shanghai"),
 * entry("JST", "Asia/Tokyo"),
 */
public class WorldClock {
    public static void main(String[] args) {
        args = new String[]{"CTT", "JST"};
        Stream.of(args)
                .map(ZoneId.SHORT_IDS::get)
                .map(ZoneId::of)
                .map(ZonedDateTime::now)
                .map(time -> time.format(DateTimeFormatter.ofPattern("E, dd MMM u hh:mm:ss a z")))
                .forEach(System.out::println);
    }
}
