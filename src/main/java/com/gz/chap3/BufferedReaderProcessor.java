package com.gz.chap3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author xiaozefeng
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader b) throws IOException;
}
