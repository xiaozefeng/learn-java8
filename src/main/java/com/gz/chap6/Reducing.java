package com.gz.chap6;


import java.util.List;

import static java.util.stream.Collectors.reducing;

/**
 * @author xiaozefeng
 */
public class Reducing {
    public static void main(String[] args) {
        List<Dish> menus = Dish.menu;

        Integer total1 = menus.stream()
                .collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(total1);

        Integer total2 = menus.stream().map(Dish::getCalories).reduce(0, (i, j) -> i + j);
        System.out.println(total2);


        Integer total3 = menus.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println(total3);

        Integer total4 = menus.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum)
                .get();
        System.out.println(total4);

        int total5 = menus.stream()
                .mapToInt(Dish::getCalories).sum();
        System.out.println(total5);

    }
}
