package com.fancita.practice.dp;

import java.util.Scanner;

/**
 * Created by fancita on 17/10/16.
 * https://www.hackerrank.com/challenges/maxsubarray?h_r=next-challenge&h_v=zen
 */
public class TheMaximumSubarrayApp {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int t = reader.nextInt();
        /*System.out.println("t = " + t);*/

        while (t > 0) {
            t--;

            int sizeOfArray = reader.nextInt();  // retN
            /*System.out.println("sizeOfArray = " + sizeOfArray);*/

            int maxContiguousSubarraySum = Integer.MIN_VALUE;
            int maxContiguousSubarraySumPresent = 0;
            int maxNonContiguousSubarraySum = Integer.MIN_VALUE;

            while (sizeOfArray > 0) {
                sizeOfArray--;

                int presentElement = reader.nextInt();
                /*System.out.println("presentElement = " + presentElement);*/

                if (maxContiguousSubarraySum < 0) {
                    if (presentElement > maxContiguousSubarraySum) {
                        maxContiguousSubarraySum = presentElement;
                        maxContiguousSubarraySumPresent = presentElement;
                    }
                } else  {
                    maxContiguousSubarraySumPresent += presentElement;
                    if (maxContiguousSubarraySumPresent < 0) {
                        maxContiguousSubarraySumPresent = 0;
                    } else if (maxContiguousSubarraySumPresent > maxContiguousSubarraySum) {
                        maxContiguousSubarraySum = maxContiguousSubarraySumPresent;
                    }
                }

                if (presentElement < 0) {
                    if (presentElement > maxNonContiguousSubarraySum) {
                        maxNonContiguousSubarraySum = presentElement;
                    }
                } else {
                    if (maxNonContiguousSubarraySum > 0) {
                        maxNonContiguousSubarraySum += presentElement;
                    } else {
                        maxNonContiguousSubarraySum = presentElement;
                    }
                }
            }

            System.out.println(maxContiguousSubarraySum + " " + maxNonContiguousSubarraySum);
        }
    }
}
