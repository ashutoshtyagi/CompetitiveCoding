package com.fancita.practice.dp;

import java.util.Scanner;

/**
 * Created by fancita on 24/10/16.
 */
public class CoinChange {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        int sizeOfArr = reader.nextInt();
        int[] arr = new int[sizeOfArr];
        for (int i = 0; i < sizeOfArr; i++) {
            arr[i] = reader.nextInt();
        }

        System.out.print(getCoinChange(arr, n));
    }

    private static long getCoinChange(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }

        long[][] dp = new long[n + 1][arr.length];

        for (int sum = 0; sum <= n; sum++) {
            for (int lastIndex = 0; lastIndex < arr.length; lastIndex++) {
                dp[sum][lastIndex] = getValueFromDp(dp, sum - arr[lastIndex], lastIndex)
                                        + getValueFromDp(dp, sum, lastIndex - 1);
            }
        }

        return dp[n][arr.length - 1];
    }

    private static long getValueFromDp(long[][] dp, int n, int lastIndex) {
        if (n < 0 || (n > 0 && lastIndex < 0) || (n == 0 && lastIndex < -1)) {
            return 0;
        } else if (n == 0 && lastIndex == -1) {
            return 1;
        } else {
            return dp[n][lastIndex];
        }
    }
}
