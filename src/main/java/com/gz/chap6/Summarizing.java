package com.gz.chap6;


import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

/**
 * @author xiaozefeng
 */
public class Summarizing {
    public static void main(String[] args) {
        List<Dish> menus = Dish.menu;

        Long howManyDish = menus.stream()
                .collect(counting());

        System.out.println(howManyDish);

        System.out.println("----");

        Dish mostCaloricDish = menus.stream()
                .collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
        System.out.println(mostCaloricDish);

        // 第二种方式实现
        Optional<Dish> mostCaloricDish1 = menus.stream()
                .reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);
        mostCaloricDish1.ifPresent(System.out::println);
        System.out.println("-----");

        // sum
        Integer sum = menus.stream()
                .collect(summingInt(Dish::getCalories));
        System.out.println(sum);

        // avg
        Double average = menus.stream()
                .collect(averagingInt(Dish::getCalories));
        System.out.println(average);
        System.out.println("-----");

        IntSummaryStatistics statistics = menus.stream()
                .collect(summarizingInt(Dish::getCalories));

        System.out.println(statistics);
        System.out.println("----");

        // join
        String str = menus.stream()
                .map(Dish::getName)
                .collect(joining());
        System.out.println(str);

        // join
        String delimiter = menus.stream()
                .map(Dish::getName)
                .collect(joining(", "));
        System.out.println(delimiter);



    }
}
