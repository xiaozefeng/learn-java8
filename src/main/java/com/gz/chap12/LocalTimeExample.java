package com.gz.chap12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author xiaozefeng
 */
public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);
        System.out.println(now.getHour() + "时");
        System.out.println(now.getMinute() + "分");
        System.out.println(now.getSecond() + "秒");

        LocalTime parse = LocalTime.parse("11:45:11");
        System.out.println(parse);

        // LocalTime 转换成LocalDateTime
        LocalDateTime localDateTime = now.atDate(LocalDate.now());
        System.out.println(localDateTime);
    }
}
