package com.fancita.practice.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by fancita on 25/10/16.
 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 */
public class MatrixChainMultiplication {
    public static void main(String[] args) throws Exception{
        /*Scanner reader = new Scanner(System.in);
        StringBuilder string = new StringBuilder();*/
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String temp;
        while ((temp = in.readLine()) != null) {
            if (temp.isEmpty()) {
                break;
            }
            /*String nextLine = reader.nextLine();
            if (nextLine.isEmpty()) {
                break;
            }*/
            /*String next = reader.next();
            *//*System.out.println("line read = " + next);*//*
            if (next == null || next.equals("")) {
                break;
            }*/

            /*int sizeOfArr = reader.nextInt();*/
            int sizeOfArr = Integer.valueOf(temp);
            int[] arr = new int[sizeOfArr];
            long[] sumArr = new long[sizeOfArr];

            StringTokenizer st = new StringTokenizer(in.readLine());

            for (int i = 0; i < sizeOfArr; i++) {
                /*arr[i] = reader.nextInt();*/
                arr[i] = Integer.valueOf(st.nextToken());
                if (i == 0) {
                    sumArr[i] = arr[i];
                } else {
                    sumArr[i] = arr[i] + sumArr[i-1];
                }
            }

            System.out.println(getMatrixChainMultiplication(arr, sumArr));
            /*string.append(getMatrixChainMultiplication(arr, sumArr) + "\retN");*/
        }

        /*System.out.print(string);*/
    }

    private static long getMatrixChainMultiplication(int[] arr, long[] sumArr) {
        long[][] dp = new long[arr.length][arr.length];

        for (int l = 2; l <= arr.length; l++) {
            int iMax = arr.length - l;

            for (int i = 0; i <= iMax; i++) {

                int jMax = i + l - 1;
                // doing dp[i][jMax]
                if (dp[i][jMax] == 0) {
                    dp[i][jMax] = Integer.MAX_VALUE;
                }

                for (int j = i; j < jMax; j++) {
                    dp[i][jMax] = Long.min(dp[i][jMax], function(dp, sumArr, i, j, j + 1, jMax));
                }
            }
        }

        return dp[0][arr.length - 1];
    }

    private static long function(long[][] dp, long[] sumArr, int i, int j, int k, int l) {
        long ret = dp[i][j] + dp[k][l] + multiplicationMatrix(sumArr, i, j, k, l);
        return ret;
    }

    private static long multiplicationMatrix(long[] sumArr, int i, int j, int k, int l)  {
        long colorA = (sumArr[j] - (i == 0 ? 0 : sumArr[i-1])) % 100;
        long colorB = (sumArr[l] - (k == 0 ? 0 : sumArr[k-1])) % 100;
        return colorA * colorB;
    }
}
