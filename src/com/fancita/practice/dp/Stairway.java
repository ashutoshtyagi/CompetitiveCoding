package com.fancita.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fancita on 23/10/16.
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * https://www.hackerrank.com/contests/frost-byte-final/challenges/stairway
 */
public class Stairway {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int t = reader.nextInt();

        while (t > 0) {
            t--;

            int sizeOfArr = reader.nextInt();
            int[] arr = new int[sizeOfArr];

            for (int i = 0; i < sizeOfArr; i++) {
                arr[i] = reader.nextInt();
            }

            System.out.println(getMinNoOfJumpsToReachEnd(arr, sizeOfArr));
        }
    }

    private static int getMinNoOfJumpsToReachEnd(int[] arr, int sizeOfArr) {
        if (arr[0] == 0) {
            return -1;
        }

        int[] dp = new int[sizeOfArr + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < sizeOfArr + 1; i++) {
            for (int j = 0; j < i; j++) {
                int distance = i - j;
                if (arr[j] + distance >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Integer.min(dp[i], 1 + dp[j]);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }

        return dp[sizeOfArr];
    }
}
