package com.fancita.practice.dp;

import com.fancita.utils.FastIO;

/**
 * Created by fancita on 1/11/16.
 * http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
 */
public class MinimumInsertionsToFormAPalindrome extends FastIO {

    public static void main(String[] args) {
        int t = reader.readInt();

        while (t-- > 0) {
            String str = reader.readString();

            writer.printLine(getMinimumInsertionsToFormAPalindrome(str));
        }

        writer.flush();
        writer.close();
    }

    private static int getMinimumInsertionsToFormAPalindrome(String str) {
        char[] charArr = str.toCharArray();
        int[][] dp = new int[str.length()][str.length()];

        for (int i = 0; i < charArr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (charArr[j] == charArr[i]) {
                    dp[j][i] = getValFromDp(dp, j+1, i-1);
                } else dp[j][i] = Integer.min(getValFromDp(dp, j+1, i), getValFromDp(dp, j, i-1)) + 1;
            }
        }

        return dp[0][str.length() - 1];
    }

    private static int getValFromDp(int[][] dp, int i, int j) {
        if (i >= j) {
            return 0;
        } else return dp[i][j];
    }
}
