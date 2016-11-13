package com.fancita.practice.dp;

import java.util.Scanner;

/**
 * Created by fancita on 29/10/16.
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=494
 */
public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int t = reader.nextInt();
        while (t > 0) {
            t--;

            int n = reader.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextInt();
            }

            System.out.println(getMaximumSumIncreasingSubsequence(arr));
        }
    }

    private static int getMaximumSumIncreasingSubsequence(int[] arr) {
        int dp[] = new int[arr.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                dp[i] = Integer.max(dp[i], arr[j] <= arr[i] ? dp[j] + arr[i] : 0);
            }
            max = Integer.max(max, dp[i]);
        }

        return max;
    }
}
