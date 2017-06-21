package com.fancita.leetcode.BinarySearch;

/**
 * Created by ashutosh on 16/1/17.
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(808201));
    }

    public boolean isPerfectSquare(int num) {
        int left = 0, right =  num;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * (long) mid;
            if (sq == num) return true;
            if (sq < num) left = mid + 1;
            else right = mid - 1;
        }

        if (left == right && left * left == num) {
            return true;
        } else return false;
    }
}
