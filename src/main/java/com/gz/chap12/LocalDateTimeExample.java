package com.gz.chap12;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * @author xiaozefeng
 */
public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime dt1 = LocalDateTime.of(2018, Month.JANUARY, 18, 11, 45, 20);
        System.out.println(dt1);
        
    }
}
