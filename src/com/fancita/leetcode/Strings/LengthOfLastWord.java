package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 1/3/17.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("  "));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.contains(" ") == true ? s.substring(s.lastIndexOf(" ") + 1, s.length()).length() : s.length();
    }
}
