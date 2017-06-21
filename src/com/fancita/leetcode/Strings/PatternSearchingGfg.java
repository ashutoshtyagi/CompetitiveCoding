package com.fancita.leetcode.Strings;

import com.fancita.utils.FastIO;

/**
 * Created by ashutosh on 18/2/17.
 */
public class PatternSearchingGfg extends FastIO {

    public static void main(String[] args) {
        int t = reader.readInt();
        while (t-- > 0) {
            String text = reader.readString();
            String pattern = reader.readString();
            KMP kmp = new KMP(pattern);
            int startingIndex = kmp.findPattern(text);
            if (startingIndex == -1) {
                System.out.println("not found");
            } else System.out.println("found");
        }
    }

    private static class KMP {

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

}
