package com.gz.chap5;

import com.gz.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xiaozefeng
 */
public class NumericStream {
    public static void main(String[] args) {
        // 求和
        List<Dish> menus = Dish.menu;
        int sum = menus.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(sum);
        // max
        OptionalInt max = menus.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int maxInt = max.getAsInt();
        System.out.println(maxInt);

        // 平均数
        OptionalDouble average = menus.stream()
                .mapToInt(Dish::getCalories)
                .average();
        double asDouble = average.getAsDouble();
        System.out.println(asDouble);

        // 数值流转换成对象流
        menus.stream()
                .mapToInt(Dish::getCalories)
                .boxed()
                .forEach(System.out::println);

        // 数值范围
        IntStream.range(1, 50)
                .forEach(v -> System.out.print(v + ","));
        System.out.println("-----");
        IntStream.rangeClosed(1, 50)
                .forEach(v -> System.out.print(v + ","));
        System.out.println("---");

        // 勾股数生成
        Stream<int[]> stream = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );
        stream.forEach(arr -> System.out.println(Arrays.toString(arr)));

        System.out.println("--------");

        // 只需要求一次平方根
        Stream<double[]> doubleStream = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0));
        doubleStream.forEach(t -> System.out.println(Arrays.toString(t)));

    }
}
