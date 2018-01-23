package com.gz.chap11;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author xiaozefeng
 */
public class BestPriceFinderMain {
    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("花费" + duration + "毫秒");
    }

    public static void main(String[] args) {
        execute("sequential", () -> bestPriceFinder.findPricesSequential("myPhone27S"));
        execute("parallel", () -> bestPriceFinder.findPricesParalle("myPhone27S"));
        execute("composed CompletableFuture", () -> bestPriceFinder.findPricesFuture("myPhone27S"));
    }
}
