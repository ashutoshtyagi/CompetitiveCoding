package com.fancita.leetcode.Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ashutosh on 24/4/17.
 */
public class KLengthCombinations {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new KLengthCombinations().getCombinations("aaaaaaa", 3).toArray()));
    }

    private Set<String> getCombinations(String string, int k) {
        if(string == null || string.length() <= k) {
            Set<String> ret = new HashSet<>();
            ret.add(string);
            return ret;
        }

        char[] charArr = string.toCharArray();
        Arrays.sort(charArr);

        Set<String> ret = new HashSet<>();
        StringBuilder sb = new StringBuilder(k);
        recurse(charArr, ret, sb, 0, k, 0);
        return ret;
    }

    private void recurse(char[] chars, Set<String> set, StringBuilder sb, int startIndex, int k, int lengthTillNow) {
        if(lengthTillNow == k) {
            set.add(sb.toString());
            return;
        }

        char lastChar = '$';
        for (int i = startIndex; i <= chars.length - (k - lengthTillNow); i++) {
            if (chars[i] != lastChar) {
                sb.append(chars[i]);
                recurse(chars, set, sb, i + 1, k, lengthTillNow + 1);
                sb.setLength(sb.length() - 1);
                lastChar = chars[i];
            }
        }

        return;
    }
}
