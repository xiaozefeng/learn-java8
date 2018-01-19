package com.gz.chap6;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * @author xiaozefeng
 */
public class Partitioning {
    public static void main(String[] args) {
        List<Dish> menus = Dish.menu;

        // 分区
        // 分区是一种特殊的groupingBy
        // 分区只会返回两组元素流 true or false
        Map<Boolean, List<Dish>> partitionedMenu = menus.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);

        System.out.println("-----");
        List<Dish> vegetarianDishes = menus.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        System.out.println(vegetarianDishes);
        // 分区相比 filter 的优势，可以保留两套元素流

        System.out.println("-----");
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menus.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType);

        System.out.println("---");
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menus.stream()
                .collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);

        System.out.println("---");
        Map<Boolean, Long> count = menus.stream()
                .collect(partitioningBy(Dish::isVegetarian, counting()));
        System.out.println(count);


        // 将数据按质数和非质数分区
        boolean prime = isPrime(11);
        boolean prime1 = isPrime1(11);
        System.out.println(prime);
        System.out.println(prime1);

        Map<Boolean, List<Integer>> booleanListMap = partitionPromes(20);
        booleanListMap.forEach((k,v) ->{
            if (k) {
                System.out.println("质数" +v);
            }else {
                System.out.println("非质数"+ v);
            }
        });
    }

    private static boolean isPrime(int candidate) {
        return IntStream.range(2, candidate)
                .noneMatch(i -> candidate % i == 0);
    }

    /**
     * 优化求这个数是不是质数， 拿这个数的平方根去除
     *
     * @param candidate
     * @return
     */
    private static boolean isPrime1(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    private static  Map<Boolean, List<Integer>> partitionPromes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(Partitioning::isPrime1));
    }

}
