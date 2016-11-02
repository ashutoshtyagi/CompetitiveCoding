package com.ashutosh.hackerrank.dp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ashutosh on 17/10/16.
 * https://www.hackerrank.com/challenges/array-splitting?h_r=next-challenge&h_v=zen
 */
public class NikitaAndTheGameApp {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int t = reader.nextInt();

        while (t > 0) {
            t--;

            int sizeOfArray = reader.nextInt();

            BigInteger sumArr = BigInteger.ZERO;
            List<Integer> arr = new ArrayList<>(sizeOfArray);

            while (sizeOfArray > 0) {
                sizeOfArray--;

                int presentInt = reader.nextInt();
                sumArr = sumArr.add(BigInteger.valueOf(presentInt));
                arr.add(presentInt);
            }

            int maxScore = getMaxScore(arr, sumArr);
            System.out.println(maxScore);
        }
    }

    private static int getMaxScore(List<Integer> arr, BigInteger sumArr) {
        if (arr.size() == 1) {
            return 0;
        }

        BigInteger[] halfSumAndRemainder = sumArr.divideAndRemainder(BigInteger.valueOf(2));
        BigInteger halfSum = halfSumAndRemainder[0];
        BigInteger remainder = halfSumAndRemainder[1];
        if (!remainder.equals(BigInteger.ZERO)) {
            return 0;
        }


        BigInteger sumTillNow = BigInteger.ZERO;
        int breakAtIndex = -1;
        int presentI = 0;
        for (Integer presentInt : arr) {
            sumTillNow = sumTillNow.add(BigInteger.valueOf(presentInt));
            if (sumTillNow.equals(halfSum)) {
                breakAtIndex = presentI;
                break;
            }
            presentI++;
        }

        if (breakAtIndex != -1) {
            return 1 + Integer.max(getMaxScore(arr.subList(0, breakAtIndex + 1), halfSum),
                    getMaxScore(arr.subList(breakAtIndex + 1, arr.size()), halfSum));
        } else {
            return 0;
        }
    }
}
