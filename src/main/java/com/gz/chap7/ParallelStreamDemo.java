package com.gz.chap7;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author xiaozefeng
 */
public class ParallelStreamDemo {
    public static void main(String[] args) {
        //Long sum = Stream.iterate(1L, i -> i + 1)
        //        .limit(100)
        //        .parallel()
        //        .reduce(0L, Long::sum);
        //
        //System.out.println(sum);
        //
        //// 获取当前cpu内核数
        //int i = Runtime.getRuntime().availableProcessors();
        //System.out.println(i);

        // 因为使用了iteate，所以流在一开始没有装备好，这种操作不适合用fork/join的形式去做，只会消耗更多的性,
        // 并且还有装箱拆箱的动作
        //System.out.println("Sequential Sum done in: " + measurePerf(ParallelStreams::sequentialSum, 10_000_000L) + " msecs");
        //System.out.println("Parallel forkJoinSum done in: " + measurePerf(ParallelStreams::parallelSum, 10_000_000L) + " msecs");

        System.out.println("LongStream RangeClosed done in: " + measurePerf(n -> LongStream.rangeClosed(1, n).reduce(0L,Long::sum), 10_000_000));

        System.out.println("parallelSream RnageClosed done in: " + measurePerf(n -> LongStream.rangeClosed(1, n).parallel().reduce(0L,Long::sum), 10_000_000));

    }


    public static <T, R> long measurePerf(Function<T, R> f, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            //System.out.println("result= " + result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}
