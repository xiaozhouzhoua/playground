package com.some.playground.funs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * GregorianCalendar是一个计算函数，是 Calendar 的一个具体子类，
 * 提供了世界上大多数国家/地区使用的标准日历系统。
 */
public class DateFormatDemo {
    public static void main(String[] args) {
        String format = "dd-MMMM-yyyy";
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        System.out.println(sdf.format(calendar.getTime()));
    }
}
