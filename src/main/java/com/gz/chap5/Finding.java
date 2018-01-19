package com.gz.chap5;

import com.gz.chap4.Dish;

import java.util.List;
import java.util.Optional;

/**
 * @author xiaozefeng
 */
public class Finding {
    public static void main(String[] args) {
        List<Dish> menus = Dish.menu;

        // anyMatch 只要有一个匹配
        boolean isVegetarianFriendlyMenu = menus.stream()
                .anyMatch(Dish::isVegetarian);
        System.out.println(isVegetarianFriendlyMenu);

        System.out.println("---");

        // allMatch 全部匹配
        boolean isHealthyMenu = menus.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealthyMenu);

        System.out.println("---");

        // noMatch 和 allMatch 相反
        boolean isHealthyMenu2 = menus.stream()
                .noneMatch(d -> d.getCalories() >= 1000);

        System.out.println(isHealthyMenu2);
        System.out.println("---");


        Optional<Dish> dish = menus.stream()
                .filter(Dish::isVegetarian)
                .findFirst();

        // 如何Optional 包含值，返回true
        dish.ifPresent(d -> System.out.println(d.getName()));

        Optional<Integer> reduce = menus.stream()
                .map(d -> 1)
                .reduce(Integer::sum);
        reduce.ifPresent(System.out::println);
    }
}
