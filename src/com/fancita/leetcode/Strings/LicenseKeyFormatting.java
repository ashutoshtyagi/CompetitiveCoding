package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 27/3/17.
 */
public class LicenseKeyFormatting {
    public static void main(String[] args) {
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("---1-2--0-", 4));
    }

    public String licenseKeyFormatting(String S, int k) {
        char[] charArr = S.toCharArray();
        StringBuilder sb = new StringBuilder(charArr.length);
        int kIt = 0;
        for (int i = charArr.length - 1; i >= 0; i--) {
            if (charArr[i] == '-') continue;
            sb.append(Character.toUpperCase(charArr[i]));
            kIt++;
            if (kIt == k) {
                kIt = 0;
                sb.append("-");
            }
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') sb = sb.deleteCharAt(sb.length() - 1);

        return reverseString(sb.toString());
    }

    private String reverseString(String string) {
        int i = 0, j = string.length() - 1;
        char[] charArr = string.toCharArray();
        while (i < j) {
            char a = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = a;
            i++;
            j--;
        }
        return new String(charArr);
    }
}
