package com.fancita.leetcode.Backtracking;

import java.util.Collections;
import java.util.List;

/**
 * Created by ashutosh on 25/3/17.
 * https://leetcode.com/problems/different-ways-to-add-parentheses/#/description
 * 241
 */
public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {

    }

    public List<Integer> diffWaysToCompute(String input) {
        int[] numbers = new int[input.length()/2 + 1];
        char[] operations = new char[numbers.length - 1];

        char[] inputCharArr = input.toCharArray();
        int j = 0, k = 0;
        for (int i = 0; i < inputCharArr.length; i++) {
            if (i % 2 == 0) {
                numbers[j] = inputCharArr[i];
                j++;
            } else {
                operations[k] = inputCharArr[i];
                k++;
            }
        }

        return Collections.emptyList();
    }

    /* input could be like (1 * (3 - 2))*/
    /*private int calculate(String string) {

    }*/
}
