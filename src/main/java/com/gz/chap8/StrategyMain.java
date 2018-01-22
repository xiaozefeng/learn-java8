package com.gz.chap8;

/** 策略模式使用lambda
 * @author xiaozefeng
 */
public class StrategyMain {
    public static void main(String[] args) {

        Validator v1 = new Validator(s -> s.matches("\\d+"));
        System.out.println(v1.validate("aaaa"));
        Validator v2 = new Validator(s -> s.matches("[a-z]+"));
        System.out.println(v2.validate("bbbb"));
    }
}
