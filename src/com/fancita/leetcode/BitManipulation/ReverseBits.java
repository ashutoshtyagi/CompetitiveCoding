package com.fancita.leetcode.BitManipulation;

/**
 * Created by ashutosh on 28/3/17.
 */
public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(43261596 ));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = n;
        ret = ((ret & 0b00000000000000001111111111111111) << 16) | ((ret & 0b11111111111111110000000000000000) >> 16);
        System.out.println(ret);
        ret = ((ret & 0b00000000111111110000000011111111) << 8) | ((ret & 0b11111111000000001111111100000000) >> 8);
        System.out.println(ret);
        ret = ((ret & 0b00001111000011110000111100001111) << 4) | ((ret & 0b11110000111100001111000011110000) >> 4);
        System.out.println(ret);
        ret = ((ret & 0b00110011001100110011001100110011) << 2) | ((ret & 0b11001100110011001100110011001100) >> 2);
        System.out.println(ret);
        ret = ((ret & 0b01010101010101010101010101010101) << 1) | ((ret & 0b10101010101010101010101010101010) >> 1);
        System.out.println(ret);
        return ret;
    }
}
