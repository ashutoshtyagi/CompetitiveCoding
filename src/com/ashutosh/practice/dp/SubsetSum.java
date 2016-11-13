package com.ashutosh.practice.dp;

import com.ashutosh.utils.FastIO;

/**
 * Created by ashutosh on 1/11/16.
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 */
public class SubsetSum extends FastIO {

    public static void main(String[] args) {
        int t = reader.readInt();
        while (t-- > 0) {
            int n = reader.readInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = reader.readInt();
                sum += arr[i];
            }

            writer.printLine(sum %2 == 0? (getSubsetSum(arr, sum) ? "YES" : "NO") : "NO");
        }

        writer.flush();
        writer.close();
    }

    private static boolean getSubsetSum(int[] arr, int totalSum) {
        if (totalSum == 0) {
            return  true;
        }

        int halfSum = totalSum / 2;
        boolean[][] dp = new boolean[halfSum + 1][arr.length];

        for (int sum = 1; sum <= halfSum; sum++) {
            for (int i = 0; i < arr.length; i++) {
                dp[sum][i] = getValFromDp(dp, sum, i - 1) || getValFromDp(dp, sum - arr[i], i - 1);
            }
        }

        return dp[halfSum][arr.length - 1];
    }

    private static boolean getValFromDp(boolean[][] dp, int sum, int i) {
        if (sum < 0) {
            return false;
        } else if (sum == 0 && i < 0) {
            return true;
        } else if (sum > 0 && i < 0) {
            return false;
        } else return dp[sum][i];
    }
}
