package com.fancita.practice.NumberTheory;

/**
 * Created by ashutosh on 18/11/16.
 */
public class SmallestPrimeFactor {
    public static void main(String[] args) {
        int n = smallestPrimeFactor(2749);
        System.out.println(n);
    }

    public static long smallestPrimeFactor(long n) {
        if (n==0 || n==1) return n;
        if (n%2==0) return 2;
        if (n%3==0) return 3;
        if (n%5==0) return 5;

        for (long i = 7; (i*i) <= n; i += 30 ) {
            if ( n % i == 0 ) {
                return i;
            }
            if ( n % ( i+4 ) == 0) {
                return i+4;
            }
            if ( n % ( i+6 ) == 0) {
                return i+6;
            }
            if ( n % ( i+10 ) == 0) {
                return i+10;
            }
            if ( n % ( i+12 ) == 0) {
                return i+12;
            }
            if ( n % ( i+16 ) == 0) {
                return i+16;
            }
            if ( n % ( i+22 ) == 0) {
                return i+22;
            }
            if ( n % ( i+24 ) == 0) {
                return i+24;
            }
        }
        return n;
    }

    public static int smallestPrimeFactor(int n) {
        if (n==0 || n==1) return n;
        if (n%2==0) return 2;
        if (n%3==0) return 3;
        if (n%5==0) return 5;

        for (int i = 7; (i*i) <= n; i += 30 ) {
            if ( n % i == 0 ) {
                return i;
            }
            if ( n % ( i+4 ) == 0) {
                return i+4;
            }
            if ( n % ( i+6 ) == 0) {
                return i+6;
            }
            if ( n % ( i+10 ) == 0) {
                return i+10;
            }
            if ( n % ( i+12 ) == 0) {
                return i+12;
            }
            if ( n % ( i+16 ) == 0) {
                return i+16;
            }
            if ( n % ( i+22 ) == 0) {
                return i+22;
            }
            if ( n % ( i+24 ) == 0) {
                return i+24;
            }
        }
        return n;
    }
}
