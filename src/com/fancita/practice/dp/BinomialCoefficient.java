package com.fancita.practice.dp;

import java.math.BigInteger;

/**
 * Created by fancita on 26/10/16.
 */
public class BinomialCoefficient {

    public static BigInteger bigIntegerBinomialCoefficient(int x, int y) {
        if (y < 0 || y > x)
            return BigInteger.ZERO;
        if (y == 0 || y == x)
            return BigInteger.ONE;

        BigInteger answer = BigInteger.ONE;
        for (int i = x - y + 1; i <= x; i++) {
            answer = answer.multiply(BigInteger.valueOf(i));
        }
        for (int j = 1; j <= y; j++) {
            answer = answer.divide(BigInteger.valueOf(j));
        }
        return answer;
    }

    public static double efficientBinomialCoefficient(int x, int y) {
        if (y < 0 || y > x) return 0;
        if (y > x/2) {
            // choose(n,k) == choose(n,n-k),
            // so this could save a little effort
            y = x - y;
        }

        double denominator = 1.0, numerator = 1.0;
        for (int i = 1; i <= y; i++) {
            denominator *= i;
            numerator *= (x + 1 - i);
        }
        return numerator / denominator;
    }

    public static int dpBinomialCoeff(int n, int k)
    {
        int C[][] = new int[n+1][k+1];
        int i, j;

        // Calculate value of Binomial Coefficient in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (j = 0; j <= min(i, k); j++)
            {
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;

                    // Calculate value using previosly stored values
                else
                    C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }

        return C[n][k];
    }

    // A utility function to return minimum of two integers
    static int min(int a, int b)
    {
        return (a<b)? a: b;
    }

    /* Driver program to test above function*/
    public static void main(String args[])
    {
        int n = 5, k = 2;
        System.out.println("Value of C("+n+","+k+") is "+ dpBinomialCoeff(n, k));
    }

}