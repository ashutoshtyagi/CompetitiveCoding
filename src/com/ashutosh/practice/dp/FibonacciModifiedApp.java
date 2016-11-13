package com.ashutosh.practice.dp;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by ashutosh on 12/10/16.
 * https://www.hackerrank.com/challenges/fibonacci-modified
 */
public class FibonacciModifiedApp {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int t1  = reader.nextInt();
        int t2 = reader.nextInt();
        int n = reader.nextInt();
        BigInteger tn = getNthFibonacci(t1, t2, n);
        System.out.print(tn.toString());
    }

    private static BigInteger getNthFibonacci(int t1, int t2, int n) {
        BigInteger tn = new BigInteger("0");
        BigInteger t1n = BigInteger.valueOf(t1);
        BigInteger t2n = BigInteger.valueOf(t2);
        for (int i = 3; i <= n; i++) {
            tn = t1n.add(t2n.multiply(t2n));
            t1n = t2n;
            t2n = tn;
        }
        return tn;
    }
}
