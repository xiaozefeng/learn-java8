package com.gz.chap5;

import com.gz.chap4.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author xiaozefeng
 */
public class Filtering {
    public static void main(String[] args) {
        List<Dish> menus = Dish.menu;

        // 过滤
        List<Dish> vegetarianMenu = menus.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        vegetarianMenu.forEach(System.out::println);
        System.out.println("---");

        // 去重
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 2, 4, 2, 2, 2, 2, 4, 5, 6, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        System.out.println("---");

        // limit
        menus.stream()
                .filter(d -> d.getCalories() >300)
                .limit(3)
                .forEach(System.out::println);
        System.out.println("---");


        // skip
        menus.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .forEach(System.out::println);
        System.out.println("---");




    }
}
