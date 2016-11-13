package com.fancita.practice.NumberTheory;

/**
 * Created by fancita on 10/11/16.
 */
public class LCM_GCD {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) { return a * (b / gcd(a, b)); }
}
