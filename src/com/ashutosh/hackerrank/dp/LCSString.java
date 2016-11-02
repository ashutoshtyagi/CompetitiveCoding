package com.ashutosh.hackerrank.dp;

import java.util.Scanner;

/**
 * Created by ashutosh on 23/10/16.
 * http://www.spoj.com/problems/EELCS/
 * http://www.spoj.com/problems/LCS0/  COULDN'T SOLVE, RUNTIME ERROR
 */
public class LCSString {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String first = reader.nextLine();
        String second = reader.nextLine();

        System.out.print(LCSString(first, second));
    }

    private static int LCSString(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int dp[][] = new int[a.length()][b.length()];

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (aArr[i] == bArr[j]) {
                    dp[i][j] = 1 + getValueFromDp(dp, i-1, j-1);
                } else {
                    dp[i][j] = Integer.max(getValueFromDp(dp, i-1, j), getValueFromDp(dp, i, j-1));
                }
            }
        }

        return dp[a.length()-1][b.length()-1];
    }

    private static int getValueFromDp(int[][] dp, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        return dp[i][j];
    }
}