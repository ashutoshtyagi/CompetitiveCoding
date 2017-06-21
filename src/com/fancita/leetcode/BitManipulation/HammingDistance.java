package com.fancita.leetcode.BitManipulation;

/**
 * Created by ashutosh on 29/3/17.
 */
public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(32,64));
    }

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while(xor != 0) {
            xor = (xor & (xor-1));
            count++;
        }
        return count;
    }
}
