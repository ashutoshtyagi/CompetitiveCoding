package com.fancita.practice.dp;

import java.util.Scanner;

/**
 * Created by fancita on 23/10/16.
 * http://www.spoj.com/problems/EDIST/
 * https://www.hackerrank.com/contests/cse-830-homework-3/challenges/edit-distance
 */
public class EditDistance {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int t = reader.nextInt();

        while (t > 0) {
            t--;

            String strA = reader.next();
            String strB = reader.next();

            System.out.println(ED(strA, strB));
        }
    }

    private static int ED(String strA, String strB) {
        char[] charArrA = strA.toCharArray();
        char[] charArrB = strB.toCharArray();

        int dp[][] = new int[strA.length()][strB.length()];

        for (int i = 0; i < strA.length(); i++) {
            for (int j = 0; j < strB.length(); j++) {
                if (charArrA[i] == charArrB[j]) {
                    dp[i][j] = getValueFromDp(dp, i-1, j-1);
                } else {
                    dp[i][j] = 1 + Integer.min(getValueFromDp(dp, i, j-1),
                            Integer.min(getValueFromDp(dp, i-1, j-1), getValueFromDp(dp, i-1, j)));
                }
            }
        }

        return dp[strA.length() - 1][strB.length() - 1];
    }

    private static int getValueFromDp(int[][] dp, int i, int j) {
        if (i < 0 && j >= 0) {
            return j + 1;
        } else if (i >= 0 && j < 0) {
            return i + 1;
        } else if (i < 0 && j < 0) {
            return 0;
        } else {
            return dp[i][j];
        }
    }
}
