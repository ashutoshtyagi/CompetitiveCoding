package com.ashutosh.practice.dp;

import java.util.Scanner;

/**
 * Created by ashutosh on 26/10/16.
 */
public class KnapsackProblem01 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        /*int t = reader.nextInt();

        while (t > 0) {
            t--;

            int sizeOfArr = reader.nextInt();

            int weightOfKnapsack = reader.nextInt();

            int[] w = new int[sizeOfArr];
            int[] v = new int[sizeOfArr];

            for (int i = 0; i < sizeOfArr; i++) {
                w[i] = reader.nextInt();
            }

            for (int i = 0; i < sizeOfArr; i++) {
                v[i] = reader.nextInt();
            }

            System.out.println(getKnapsack(weightOfKnapsack, w, v));
        }*/

        int weightOfKnapsack = reader.nextInt();
        int sizeOfArr = reader.nextInt();

        int[] w = new int[sizeOfArr];
        int[] v = new int[sizeOfArr];

        for (int i = 0; i < sizeOfArr; i++) {
            w[i] = reader.nextInt();
            v[i] = reader.nextInt();
        }

        System.out.println(getKnapsack(weightOfKnapsack, w, v));
    }

    private static int getKnapsack(int weightOfKnapsack, int[] w, int[] v) {
        int[][] dp = new int[weightOfKnapsack + 1][w.length];

        for (int weight = 0; weight <= weightOfKnapsack; weight++) {
            for (int i = 0; i < w.length; i++) {
                dp[weight][i] = Integer.max(getDpFromArray(dp, w, weight, i-1),
                                                v[i] +  getDpFromArray(dp, w, weight - w[i], i-1));
            }
        }

        return dp[weightOfKnapsack][w.length-1];
    }

    private static int getDpFromArray(int[][] dp, int[] w, int weight, int i) {
        if (weight < 0) {
            return Integer.MIN_VALUE;
        } else if (weight == 0 || i < 0) {
            return 0;
        } else {
            return dp[weight][i];
        }
    }
}
