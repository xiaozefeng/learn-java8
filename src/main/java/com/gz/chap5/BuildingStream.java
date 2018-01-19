package com.gz.chap5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xiaozefeng
 */
public class BuildingStream {
    public static void main(String[] args) {
        // Stream.of
        Stream<String> stream = Stream.of("Java8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase)
                .forEach(System.out::println);

        // from Array
        int[] numbers = {1, 2, 3, 4, 5, 6};
        IntStream intStream = Arrays.stream(numbers);
        int sum = intStream.sum();
        System.out.println(sum);

        // from file
        // 使用flatMap
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.forName("UTF-8"))) {
            long count = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-----");
        // iterate
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("----");
        // 裴波那契数列
        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(20)
                .forEach(t -> System.out.println(Arrays.toString(t)));

        System.out.println("-----");
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("----");

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int nextValue = previous + current;
                this.previous = current;
                this.current = nextValue;
                return this.previous;
            }
        };
        IntStream.generate(fib)
                .limit(10)
                .forEach(System.out::println);
    }
}
