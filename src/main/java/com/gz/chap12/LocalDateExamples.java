package com.gz.chap12;

import java.time.*;

/**
 * @author xiaozefeng
 */
public class LocalDateExamples {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2004, 2, 22);
        int year = date.getYear();
        System.out.println("year =" + year);
        Month month = date.getMonth();
        System.out.println("getMonth() -> " + month);
        int dayOfMonth = date.getDayOfMonth();
        System.out.println("dayOfMonth()->" + dayOfMonth);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek);

        // 这个月有多少天
        int len = date.lengthOfMonth();
        System.out.println(len);

        // 是否闰年
        boolean leapYear = date.isLeapYear();
        System.out.println(leapYear);


        // 当前时间
        LocalDate now = LocalDate.now();
        System.out.println(now);

        // 解析字符串
        LocalDate parse = LocalDate.parse("2018-01-11");
        System.out.println(parse);

        // 转换成LocalDateTime
        LocalDateTime localDateTime = date.atTime(LocalTime.now());
        System.out.println(localDateTime);

    }
}
