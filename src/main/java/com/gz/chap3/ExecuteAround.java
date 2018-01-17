package com.gz.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author xiaozefeng
 */
public class ExecuteAround {
    public static void main(String[] args) throws IOException {
        String oneLine = processFile(p -> p.readLine());
        System.out.println(oneLine);

        String towLines = processFile(p -> p.readLine() + "\n" + p.readLine());
        System.out.println(towLines);
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return processor.process(br);
        }
    }
}
