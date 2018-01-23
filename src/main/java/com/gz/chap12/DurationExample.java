package com.gz.chap12;


import java.time.*;

/**
 * 表示 LocalDate、 LocalDateTime 、 Instant 时间对象之间的差距
 * @author xiaozefeng
 */
public class DurationExample {
    public static void main(String[] args) {
        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.of(9, 11, 20);
        Duration between = Duration.between(time1, time2);
        System.out.println(between);

        LocalDateTime ldt1 = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.of(2018, 1, 1, 1, 1, 1);
        Duration between1 = Duration.between(ldt1, ldt2);
        System.out.println(between1);

        Period between2 = Period.between(LocalDate.now(), LocalDate.of(2018, 1, 1));
        System.out.println(between2.getMonths());
    }
}
