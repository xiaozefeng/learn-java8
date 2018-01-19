package com.gz.chap5;

import com.gz.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author xiaozefeng
 */
public class Mapping {
    public static void main(String[] args) {
        List<Dish> menus = Dish.menu;

        List<String> dishNames = menus.stream()
                .map(Dish::getName)
                .collect(toList());

        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);


        //String[] arrayOfWords = {"Hello", "World"};
        //Stream<String> stream = Arrays.stream(arrayOfWords);
        //stream.forEach(System.out::println);

        //List<String> uniqueCharacters = words.stream()
        //        .map(w -> w.split(""))  // [H, e, l, l, o] [W, o, r, l, d]
        //        .flatMap(Arrays::stream)
        //        .distinct()
        //        .collect(toList());
        //System.out.println(uniqueCharacters);
        //
        //words.stream()
        //        .map(w -> w.split(""))
        //        .forEach(a -> System.out.println(Arrays.toString(a)));

        // flatMap 方法让你把一个流中的每个值都换成另一个流，然后把所有流连接起来成为一个流
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        Stream<int[]> pairs = numbers1.stream()
                .flatMap((Integer i) -> numbers2.stream()
                        .map(j -> new int[]{i, j})
                )
                .filter(p -> (p[0] + p[1]) % 3 == 0);

        pairs.forEach(p -> System.out.println(Arrays.toString(p)));
    }
}
