package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 18/2/17.
 */
public class KMP {
    public static void main(String[] args) {
        String pattern = "i";
        KMP kmp = new KMP(pattern);
        String text = "i";
        int startingIndex = kmp.findPattern(text);
        if (startingIndex != -1) {
            int endIndex = startingIndex + pattern.length();
            System.out.println(text.substring(startingIndex, endIndex));
        } else System.out.println("not present");
    }

    private int[][] dfa;
    private String pattern;

    public KMP(String pattern) {
        this.pattern = pattern;
        constructDFA();
    }

    private void constructDFA() {
        dfa = new int[26][pattern.length()];
        int X = 0;

        for (int i = 0; i < 26; i++) {
            dfa[i][0] = 0;
        }
        dfa[pattern.charAt(0) - 'a'][0] = 1;

        for (int i = 1; i < pattern.length(); i++) {
            for (int j = 0; j < 26; j++) {
                dfa[j][i] = dfa[j][X];
            }
            dfa[pattern.charAt(i) - 'a'][i] = i + 1;
            X = dfa[pattern.charAt(i) - 'a'][X];
        }
    }

    public int findPattern(String text) {
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            j = dfa[text.charAt(i) - 'a'][j];
            if (j == pattern.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

}
