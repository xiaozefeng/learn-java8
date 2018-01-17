package com.gz.chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author xiaozefeng
 */
public class StreamBasic {
    public static void main(String[] args) {
        List<Dish> menus = Dish.menu;

        // Java7
        List<String> lowCaloricDishesNamesInJava7 = getLowCaloricDishesNamesInJava7(menus);
        System.out.println(lowCaloricDishesNamesInJava7);

        System.out.println("---");

        // Java8
        List<String> collect = menus.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
        System.out.println(collect);

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>(dishes.size());
        for (Dish d : dishes) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }
}
