package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 9/2/17.
 */
public class NumberOfSegmentsInString {
    public static void main(String[] args) {
        System.out.println(new NumberOfSegmentsInString().countSegments("Hello, my name is John"));
    }

    public int countSegments(String s) {
        if (s.length() == 0) return 0;

        int segments = 0;
        char prev = ' ';

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && prev == ' ') {
                segments++;
            }
            prev = s.charAt(i);
        }

        return segments;
    }
}
