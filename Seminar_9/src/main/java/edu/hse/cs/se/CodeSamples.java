package edu.hse.cs.se;

import java.util.function.LongSupplier;

/**
 * This class in aimed to contain different invocation methods to measure their execution times.
 */
public class CodeSamples implements LongSupplier {

    static long staticMethodSample() {
        return System.nanoTime();
    }

    long instanceMethodSample(){
        return System.nanoTime();
    }

    /**
     * Gets a result.
     * @return a result
     */
    @Override
    public long getAsLong() {
        return System.nanoTime();
    }
}
