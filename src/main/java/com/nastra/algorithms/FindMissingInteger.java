package com.nastra.algorithms;

/**
 * This class efficiently finds an integer value that is not contained in the input list by using a bit vector.
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class FindMissingInteger {

    private static long maxInts = ((long) Integer.MAX_VALUE) + 1;
    private static byte[] bits = new byte[(int) (FindMissingInteger.maxInts / 8)];

    private void preprocess(Iterable<Integer> numbers) {
        for (int n : numbers) {
            bits[n / 8] |= 1 << (n % 8);
        }
    }

    public int findMissingValue(Iterable<Integer> numbers) {
        preprocess(numbers);
        for (int i = 0; i < bits.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bits[i] & (1 << j)) == 0) {
                    return i * 8 + j;
                }
            }
        }
        return -1;
    }
}