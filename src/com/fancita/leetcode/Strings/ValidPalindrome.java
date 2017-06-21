package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 12/2/17.
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        /*System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));*/
        System.out.println(new ValidPalindrome().isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;

        int i = 0, j = s.length() - 1;
        while (i < j) {
            char a = Character.toLowerCase(s.charAt(i));
            char b = Character.toLowerCase(s.charAt(j));

            if (!((a >= 48 && a <= 57) || (a >= 97 && a <= 122))) {
                i++;
                continue;
            }

            if (!((b >= 48 && b <= 57) || (b >= 97 && b <= 122))) {
                j--;
                continue;
            }

            if (a != b) {
                break;
            }
            i++;
            j--;
        }

        return i >= j;
    }
}
