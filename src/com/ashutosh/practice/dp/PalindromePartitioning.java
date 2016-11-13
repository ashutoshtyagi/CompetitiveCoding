package com.ashutosh.practice.dp;

import java.util.Scanner;

/**
 * Created by ashutosh on 29/10/16.
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int t = reader.nextInt();
        while (t > 0) {
            t--;

            String str = reader.next();
            System.out.println(minCut(str));
        }
    }

    public static int minCut(String str) {
        char[] charArr = str.toCharArray();
        boolean[][] pal = new boolean[charArr.length][charArr.length];
        int[] dp = new int[charArr.length];

        for (int i = 0; i < charArr.length; i++) {
            dp[i] = i;
            for (int j = i; j >= 0; j--) {
                if (charArr[j] == charArr[i] && getValueFromPal(pal, j + 1, i - 1)) {
                    dp[i] = Integer.min(dp[i], (j > 0 ? 1 + dp[j-1] : 0));
                    pal[j][i] = true;
                } else {
                    pal[j][i] = false;
                }
            }
        }

        return dp[charArr.length - 1];
    }

    private static boolean getValueFromPal(boolean[][] pal, int i, int j) {
        if (i >= j) {
            return true;
        } else return pal[i][j];
    }

    /*public static int minCut(String str) {
        char[] charArr = str.toCharArray();
        int[][] dp = new int[charArr.length][charArr.length];

        for (int length = 1; length <= charArr.length; length++) {
            int iMax = (charArr.length - 1) - (length - 1);
            for (int i = 0; i <= iMax; i++) {
                int jMax = i + length - 1;
                if (charArr[i] == charArr[jMax] && getDpFromArray(dp, i+1, jMax-1) == 0) {
                    dp[i][jMax] = 0;
                } else {
                    dp[i][jMax] = Integer.MAX_VALUE;
                    for (int j = i; j < jMax; j++) {
                        dp[i][jMax] = Integer.min(dp[i][jMax], dp[i][j] + dp[j + 1][jMax] + 1);
                    }
                }
            }
        }

        return dp[0][charArr.length - 1];
    }

    public static int getDpFromArray(int[][] dp, int i, int j) {
        if (i > j) {
            return 0;
        } else {
            return dp[i][j];
        }
    }*/
}
