package com.fancita.leetcode.BitManipulation;

/**
 * Created by ashutosh on 28/3/17.
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        int num = 214748364;
        System.out.println(new NumberOf1Bits().hammingWeight(num));
        System.out.println(Integer.toBinaryString(num));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        while(n != 0) {
            n = n & (n - 1);
            ret++;
        }
        return ret;
    }
}
