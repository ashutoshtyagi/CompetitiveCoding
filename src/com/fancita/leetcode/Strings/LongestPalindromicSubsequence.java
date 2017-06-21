package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 1/3/17.
 * https://leetcode.com/problems/longest-palindromic-subsequence/?tab=Description
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {

    }

    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int[][] dp = new int[s.length()][s.length()];
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                int j = i + l - 1;

                dp[i][j] = s.charAt(i) == s.charAt(j) ? (i == j ? 1 : 2 + getValueFromDp(dp, i + 1, j - 1))
                        : Integer.max(getValueFromDp(dp, i, j - 1), getValueFromDp(dp, i + 1, j));
            }
        }

        return dp[0][s.length() - 1];
    }

    private int getValueFromDp(int[][] dp, int i, int j) {
        if (i > j) return 0;
        else return dp[i][j];
    }
}
