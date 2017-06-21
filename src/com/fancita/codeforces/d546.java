package com.fancita.codeforces;

import com.fancita.utils.FastIO;

/**
 * Created by ashutosh on 19/11/16.
 */
public class d546 extends FastIO {
    private static int[] dp;
    private static long[] sumDp;

    public static void main(String[] args) {
        createDps();
        int t = reader.readInt();
        while (t-- > 0) {
            int a =  reader.readInt();
            int b = reader.readInt();

            /*int sum = 0;
            for (int i = b + 1; i <= a; i++) {
                sum += dp[i];
            }*/

            writer.printLine((sumDp[a] - sumDp[b]));
        }

        writer.flush();
        writer.close();
    }

    private static void createDps() {
        dp = new int[5000001];
        sumDp = new long[5000001];
        dp[0] = 0;
        sumDp[0] = 0;
        dp[1] = 0;
        sumDp[1] = 0;
        for (int i = 2; i < 5000001; i++) {
            int smallestPrime = smallestPrimeFactor(i);
            dp[i] = 1 +  dp[i/smallestPrime];
            sumDp[i] = dp[i] + sumDp[i-1];
        }
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
