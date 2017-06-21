package com.fancita.leetcode.BinarySearch;

/**
 * Created by ashutosh on 14/1/17.
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(new ArrangingCoins().arrangeCoins(n));
    }

    public int arrangeCoins(int n) {
        int left = 0, right = n;
        int contender = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            long midSum = ((long)  middle) * ((long) (middle + 1));
            midSum = midSum / 2;
            if (midSum == n) {
                contender = middle;
                break;
            }

            if (midSum < n) {
                contender = middle;
                left = middle + 1;
            } else  {
                right = middle - 1;
            }
        }

        return contender;
    }
}
