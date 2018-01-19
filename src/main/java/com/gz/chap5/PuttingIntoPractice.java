package com.gz.chap5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toSet;


/**
 * @author xiaozefeng
 */
public class PuttingIntoPractice {
    public static void main(String[] args) {
        Trader jack = new Trader("jack", "广州");
        Trader rose = new Trader("rose", "上海");
        Trader lucy = new Trader("lucy", "广州");
        Trader tom = new Trader("tom", "广州");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(jack, 2011, 300),
                new Transaction(rose, 2012, 1000),
                new Transaction(rose, 2011, 400),
                new Transaction(lucy, 2012, 710),
                new Transaction(lucy, 2012, 700),
                new Transaction(tom, 2012, 950)
        );

        // 找到2011 年发生的交易，并且按照交易金额升序
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("---------");

        // 交易员都在哪些不同的城市呆过
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        // 第二种方式
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(toSet())
                .forEach(System.out::println);

        System.out.println("---------");

        // 查找所有来自广州的交易员, 按照姓名排序
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("广州"))
                .sorted(Comparator.comparing(t2 -> t2.getTrader().getName()))
                .distinct()
                .forEach(System.out::println);
        System.out.println("\n");

        // 第二种方式
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("广州"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
        System.out.println("---------");


        // 返回所有交易员的姓名，按照字母升序
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted(String::compareTo)
                .forEach(System.out::println);
        System.out.println("---------");

        // 有没有交易员在上海上班?
        boolean is = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("上海"));
        System.out.println(is);
        System.out.println("---------");


        // 广州上班的交易员交易总额
        Integer sum = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("广州"))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);
        System.out.println(sum);

        System.out.println("---------");

        // 交易额最高的
        Optional<Transaction> max = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .findAny();
        max.ifPresent(System.out::println);

        System.out.println("---------");

        Optional<Transaction> min= transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .findAny();
        min.ifPresent(System.out::println);

    }

}
