package com.fancita.leetcode.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashutosh on 12/2/17.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/?tab=Description
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aaaaabac"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> characterPositionMap = new HashMap<>(30);

        int lengthOfLongestSubstring = 0;

        int i = 0, j = 0;
        for (j = 0; j < s.length(); j++) {
            char presentChar = s.charAt(j);

            if (!characterPositionMap.containsKey(presentChar) || characterPositionMap.get(presentChar) < i) {
                characterPositionMap.put(presentChar, j);
            } else {
                lengthOfLongestSubstring = Integer.max(lengthOfLongestSubstring, j - i);
                i = characterPositionMap.get(presentChar) + 1;
                characterPositionMap.put(presentChar, j);
            }
        }

        lengthOfLongestSubstring = Integer.max(lengthOfLongestSubstring, j - i);

        return lengthOfLongestSubstring;
    }
}
