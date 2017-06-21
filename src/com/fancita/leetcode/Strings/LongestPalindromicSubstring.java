package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 27/2/17.
 * https://leetcode.com/problems/longest-palindromic-substring/?tab=Description
 * Input: "babad"
 * Output: "bab"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String string = "comoen";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(string));
    }

    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        String ret = "";

        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                int j = i + l - 1;

                dp[i][j] = s.charAt(i) == s.charAt(j) ? getValueFromDP(dp, i + 1, j - 1) : false;

                if (dp[i][j]) {
                    ret = l > ret.length() ? s.substring(i, j + 1) : ret;
                }
            }
        }

        return ret;
    }

    private boolean getValueFromDP(boolean dp[][], int i, int j) {
        if (i > j) return true;
        return dp[i][j];
    }
}
