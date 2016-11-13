package com.fancita.practice.dp;

import java.util.Scanner;

/**
 * Created by fancita on 23/10/16.
 * https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/forum
 * not submitted
 */
public class LCS {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n, m;
        n = reader.nextInt();
        m = reader.nextInt();

        int[] arrn = new int[n];
        int[] arrm = new int[m];

        for (int i = 0; i < n; i++) {
            arrn[i] = reader.nextInt();
        }

        for (int i = 0; i < m; i++) {
            arrm[i] = reader.nextInt();
        }

        /*System.out.print(Arrays.toString(LCSArray(arrn, retN, arrm, m)));*/
        System.out.print(LCS(arrn, n, arrm, m));
    }

    private static int LCS(int[] arrn, int n, int[] arrm, int m) {
        int[][] dp = new int[n][m];
        int[][][] seq = new int[n][m][Integer.max(n, m)];
        int[][] seqIt = new int[n][m];
        /*dp[0][0] = arrn[0] == arrm[0] ? 1 : 0;*/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrn[i] == arrm[j]) {
                    dp[i][j] = 1 + getValueFromDp(dp, i-1, j-1);
                } else {
                    dp[i][j] = Integer.max(getValueFromDp(dp, i, j-1), getValueFromDp(dp, i-1, j));
                }
            }
        }

        return getValueFromDp(dp, n-1, m-1);
    }

    private static int getValueFromDp(int[][] dp, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        return dp[i][j];
    }
}
