package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 1/3/17.
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "   a   b ";
        System.out.println(new ReverseWordsInAString().reverseWords(s));
    }

    public String reverseWords(String s) {
        if (s.length() == 0) return null;

        String reverseOfCompleteString = reverseString(s);
        String[] spaceSplitReverseOfCompleteString = reverseOfCompleteString.split(" +");

        StringBuilder retStringBuilder = new StringBuilder(s.length());
        for (String string : spaceSplitReverseOfCompleteString) {
            retStringBuilder.append(reverseString(string.trim()));
            retStringBuilder.append(" ");
        }

        return retStringBuilder.toString().trim();
    }

    private String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
