package com.ashutosh.codeforces;

import com.ashutosh.utils.FastIO;

/**
 * Created by ashutosh on 11/11/16.
 */
public class b508 extends FastIO {

    public static void main(String[] args) {
        String n = reader.readString();
        run(n);
        writer.flush();
        writer.close();
    }

    private static void run(String string) {

        int right = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        /*int[] arr = convertStringToIntArr(n);*/

        if (string.length() == 1) {
            writer.printLine(-1);
            return;
        }

        int lastDigit = string.charAt(string.length() - 1);

        for (int i = string.length() - 2; i >= 0; i--) {
            int digit = Integer.valueOf(string.charAt(i));

            if (digit % 2 == 0) {
                if (right == Integer.MAX_VALUE) {
                    right = i;
                }
                if (digit <= lastDigit) {
                    left = i;
                }
            }
        }

        if (left == Integer.MAX_VALUE) {
            if (right == Integer.MAX_VALUE) {
                writer.printLine(-1);
            } else {
                writer.printLine(swipe(string, string.length() - 1, right));
            }
        } else {
            writer.printLine(swipe(string, string.length() - 1, left));
        }

    }

    private static String swipe(String string, int i, int j) {
        char[] chars = string.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}

