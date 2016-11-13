package com.fancita.practice.dp;

import java.util.Scanner;

/**
 * Created by fancita on 1/11/16.
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=392
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int t = reader.nextInt();

        while (t > 0) {
            t--;

            String str = reader.next();
            System.out.println(getLongestPalindromeString(str));
        }
    }

    private static String getLongestPalindromeString(String str) {
        char[] charArray = str.toCharArray();
        boolean[][] pal = new boolean[charArray.length][charArray.length];
        int maxTillNow = Integer.MIN_VALUE;
        Pair pair = new Pair(0,0);

        for (int i = 0; i < charArray.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (charArray[j] == charArray[i] && getValFromPal(pal, j + 1, i - 1)) {
                    pal[j][i] = true;
                    if (i - j + 1 > maxTillNow) {
                        maxTillNow = i - j + 1;
                        pair.lowerIndex = j;
                        pair.higherIndex = i;
                    }
                } else {
                    pal[j][i] = false;
                }
            }
        }

        return str.substring(pair.lowerIndex, pair.higherIndex + 1);
    }

    private static boolean getValFromPal(boolean[][] pal, int i, int j) {
        if (i >= j) {
            return true;
        } else return pal[i][j];
    }

    private static class Pair {
        int lowerIndex, higherIndex;

        public Pair(int lowerIndex, int higherIndex) {
            this.lowerIndex = lowerIndex;
            this.higherIndex = higherIndex;
        }
    }
}
