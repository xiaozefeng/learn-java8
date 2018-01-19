package com.gz.chap6;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * @author xiaozefeng
 */
public class Grouping {
    public static void main(String[] args) {
        List<Dish> menus = Dish.menu;
        // groupBy type
        Map<Dish.Type, List<Dish>> groupDishesByType = menus.stream()
                .collect(groupingBy(Dish::getType));

        System.out.println(groupDishesByType);

        System.out.println("----");

        Map<Dish.Type, List<String>> groupDishNamesByType = menus.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

        System.out.println(groupDishesByType);

        System.out.println("----");

    }
}
