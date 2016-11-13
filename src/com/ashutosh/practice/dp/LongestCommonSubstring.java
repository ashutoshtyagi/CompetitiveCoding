package com.ashutosh.practice.dp;

import java.util.Scanner;

/**
 * Created by ashutosh on 2/11/16.
 */
public class LongestCommonSubstring /*extends FastIO*/ {

    public static void main(String[] args) {
        /*String str1 = reader.readString();
        String str2 = reader.readString();

        writer.printLine(getLongestCommonSubstring(str1, str2));
        writer.flush();
        writer.close();*/

        Scanner reader = new Scanner(System.in);
        String str1 = reader.next();
        String str2 = reader.next();
        System.out.println(getLongestCommonSubstring(str1, str2));
    }

    private static int getLongestCommonSubstring(String str1, String str2) {
        int longestCommonSubLength = 0;
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int[][] lcsuffix = new int[charArr1.length][charArr2.length];

        for (int i = 0; i < charArr1.length; i++) {
            for (int j = 0; j < charArr2.length; j++) {
                if (charArr1[i] == charArr2[j]) {
                    lcsuffix[i][j] = 1 + getValFromLcsuffix(lcsuffix, i-1, j-1);
                    longestCommonSubLength = Integer.max(longestCommonSubLength, lcsuffix[i][j]);
                } else lcsuffix[i][j] = 0;
            }
        }

        return longestCommonSubLength;
    }

    private static int getValFromLcsuffix(int[][] lcsuffix, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        } else return lcsuffix[i][j];
    }
}
