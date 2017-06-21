package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 12/2/17.
 * https://leetcode.com/problems/implement-strstr/?tab=Description
 */
public class ImplementstrStr {
    public static void main(String[] args) {
        /*System.out.println(new ImplementstrStr().strStr("abcdefghijklmnopqrstuvwxyz", "z"));*/
        System.out.println(new ImplementstrStr().strStr("abc", "abc"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (i + needle.length() - 1 >= haystack.length()) break;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == needle.length() - 1 && haystack.charAt(i + j) == needle.charAt(j)) return i;
            }
        }

        return -1;
    }
}
