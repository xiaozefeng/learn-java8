package com.gz.chap11;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author xiaozefeng
 */
public class ShopMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> doubleFuture = shop.getPriceAsync("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime
                + " msecs");
        doSomethingElse();

        Double price = doubleFuture.get();
        System.out.printf("Price is %.2f%n", price);
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    private static void doSomethingElse() {
        System.out.println("Doing something else...");
    }
}
