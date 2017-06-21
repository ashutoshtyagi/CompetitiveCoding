package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 26/2/17.
 */
public class KMPPrefix {
    public static void main(String[] args) {
        String text = "acacabacacabacacacy";
        String pattern = "acacabacacabacacac";
        System.out.println(new KMPPrefix().strStr(text, pattern));
    }

    public int strStr(String haystack, String needle) {
        int[] prefixArr = createPrefixArray(needle);

        int j = 0, i = 0;
        for (i = 0; i < haystack.length(); i++) {
            char haystackChar = haystack.charAt(i);
            char needleChar = needle.charAt(j);

            if (needleChar == haystackChar) {
                j++;
            } else {
                if (j != 0) {
                    int border = prefixArr[j - 1];
                    char needleCharRepeat = needle.charAt(border);
                    if (needleCharRepeat == haystackChar) {
                        j = border + 1;
                    } else j = 0;
                }
            }

            if (j == needle.length()) break;
        }

        return j == needle.length() ? i - needle.length() + 1 : -1;
    }

    private int[] createPrefixArray(String needle) {
        int[] prefixArr = new int[needle.length()];
        prefixArr[0] = 0;
        int border = 0;

        for (int i = 1; i < needle.length(); i++) {
            while (border > 0 && needle.charAt(border) != needle.charAt(i)) {
                border = prefixArr[border - 1];
            }

            if (needle.charAt(border) == needle.charAt(i)) {
                border += 1;
            } else {
                border = 0;
            }

            prefixArr[i] = border;
        }

        return prefixArr;
    }
}
