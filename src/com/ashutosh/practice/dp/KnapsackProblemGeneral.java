package com.ashutosh.practice.dp;

import java.util.Scanner;

/**
 * Created by ashutosh on 29/10/16.
 * https://www.hackerrank.com/challenges/unbounded-knapsack
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 */
public class KnapsackProblemGeneral {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int t = reader.nextInt();
        while (t > 0) {
            t--;

            int n = reader.nextInt();
            int k = reader.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextInt();
            }

            System.out.println(getKnapsack(arr, k));
        }
    }

    private static int getKnapsack(int[] arr, int k) {
        int[][] dp = new int[k+1][arr.length];

        for (int weight = 0; weight <= k; weight++) {
            for (int i = 0; i < arr.length; i++) {
                dp[weight][i] = Integer.max(arr[i] + getDpFromArray(dp, weight - arr[i], i),
                                                getDpFromArray(dp, weight, i - 1));
            }
        }

        return dp[k][arr.length - 1];
    }

    private static int getDpFromArray(int[][] dp, int weight, int i) {
        if (weight < 0) {
            return Integer.MIN_VALUE;
        } else if (i < 0) {
            return 0;
        } else {
            return dp[weight][i];
        }
    }

}
