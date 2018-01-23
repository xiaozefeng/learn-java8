package com.gz.chap14;

import java.util.function.Function;

/**
 * @author xiaozefeng
 */
public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> function = Integer::parseInt;
        Integer apply = function.apply("1233");
        System.out.println(apply);
    }
}
