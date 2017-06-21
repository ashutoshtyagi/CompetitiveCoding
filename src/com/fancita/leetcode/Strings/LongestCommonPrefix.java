package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 9/2/17.
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[] {
            "abcd", "abcde", "abc", "a"
        };
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];
        int lastIndex = prefix.length() - 1;

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (j = 0; j <= lastIndex && j <= strs[i].length() - 1; j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }

            lastIndex = j - 1;
        }

        return lastIndex < 0 ? "" : prefix.substring(0, lastIndex + 1);
    }
}
