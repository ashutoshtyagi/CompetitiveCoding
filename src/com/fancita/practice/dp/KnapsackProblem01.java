package com.fancita.practice.dp;

import java.util.Scanner;

/**
 * Created by fancita on 26/10/16.
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

    private static int getKnapsack(int weightOfKnapsack, int[] weights, int[] v) {
        int[][] dp = new int[weightOfKnapsack + 1][weights.length];

        for (int w = 0; w <= weightOfKnapsack; w++) {
            for (int i = 0; i < weights.length; i++) {
                dp[w][i] = Integer.max(getDpFromArray(dp, w, i-1),
                                                v[i] +  getDpFromArray(dp, w - weights[i], i-1));
            }
        }

        return dp[weightOfKnapsack][weights.length-1];
    }

    private static int getDpFromArray(int[][] dp, int weight, int i) {
        if (weight < 0) {
            return Integer.MIN_VALUE;
        } else if (weight == 0 || i < 0) {
            return 0;
        } else {
            return dp[weight][i];
        }
    }
}
