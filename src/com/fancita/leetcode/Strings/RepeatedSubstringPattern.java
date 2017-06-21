package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 9/2/17.
 * https://leetcode.com/problems/repeated-substring-pattern/
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String str = "ababc";
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern(str));
    }

    public boolean repeatedSubstringPattern(String str) {
        if (str.length() == 0 || str.length() == 1) return false;

        int length = str.length() / 2;
        while (length >= 1) {
            if (str.length() % length != 0) {
                length--;
                continue;
            }

            StringBuilder stringBuilder = new StringBuilder(str.length());
            int mult = str.length() / length;
            String substring = str.substring(0, length);
            for (int i = 1; i <= mult; i++) {
                stringBuilder.append(substring);
            }

            if (stringBuilder.toString().equals(str)) return true;

            length--;
        }

        return false;
    }

    /*public boolean repeatedSubstringPattern(String str) {
        if (str.length() == 0 || str.length() == 1) return false;

        int maxRepeatedIndex = 0;
        int presentIterator = 0;

        for (int i = 1; i <= str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(presentIterator)) {
                presentIterator++;
                presentIterator = presentIterator > maxRepeatedIndex ? 0 : presentIterator;
            } else {
                maxRepeatedIndex = i;
                presentIterator = 0;
            }
        }

        return maxRepeatedIndex < str.length() - 1 && presentIterator == 0;
    }*/
}
