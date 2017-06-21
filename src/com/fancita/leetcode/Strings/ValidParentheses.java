package com.fancita.leetcode.Strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ashutosh on 18/2/17.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String string = "[[{{}}])";
        System.out.println(new ValidParentheses().isValid(string));
    }

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        char[] charArr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>(charArr.length);

        for (int i = 0; i < charArr.length; i++) {
            if (isClosing(charArr[i])) {
                if (stack.size() == 0 || stack.pollLast() != getReverse(charArr[i])) {
                    return false;
                }
            } else {
                stack.addLast(charArr[i]);
            }
        }

        return stack.size() == 0;
    }

    private boolean isClosing(char a) {
        return a == ')' || a =='}' || a == ']';
    }

    private char getReverse(char ch) {
        switch (ch) {
            case '(':
                return ')';
            case '{':
                return '{';
            case '[':
                return ']';
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return Character.MIN_VALUE;
        }
    }
}
