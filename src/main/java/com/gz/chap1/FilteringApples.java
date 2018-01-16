package com.gz.chap1;

import com.gz.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author xiaozefeng
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);

        // lambda
        List<Apple> lambdaGreenApples = filterApples(inventory, apple -> "green".equals(apple.getColor()));
        System.out.println(lambdaGreenApples);

        List<Apple> lambdaHeavyApples = filterApples(inventory, apple -> apple.getWeight() > 150);
        System.out.println(lambdaHeavyApples);


        List<Apple> apples = filterApples(inventory, apple -> apple.getWeight() < 80 || "green".equals(apple.getColor()));
        System.out.println(apples);
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;

    }
}
