package com.fancita.projecteuler;

import com.fancita.practice.NumberTheory.SmallestPrimeFactor;

/**
 * Created by ashutosh on 18/11/16.
 */
public class pe521 {
    public static void main(String[] args) {
        long n = 1000000000000L;
        /*long n = 100;*/
        long S = calculateS(n);
        System.out.println(S);
    }

    public static long calculateS(long n) {
        long retSum = 0;
        for (long i = 2; i <= n; i++) {
            long smallestPrimeFactor = SmallestPrimeFactor.smallestPrimeFactor(i);
            retSum += smallestPrimeFactor;
        }
        return retSum % 1000000000;
    }
}
