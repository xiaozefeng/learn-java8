package com.gz.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author xiaozefeng
 */
public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 有初始值的reduce
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);

        Optional<Integer> sum2 = numbers.stream()
                .reduce(Integer::sum);
        sum2.ifPresent(System.out::println);

        // max
        int max = numbers.stream()
                .reduce(0, Integer::max);
        System.out.println(max);

        // min
        Optional<Integer> min = numbers.stream()
                .reduce(Integer::min);

        min.ifPresent(System.out::println);
    }
}
