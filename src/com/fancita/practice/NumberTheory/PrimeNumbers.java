package com.fancita.practice.NumberTheory;

import com.fancita.utils.FastIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fancita on 12/11/16.
 */
public class PrimeNumbers extends FastIO {

    public static void main(String[] args) {
        int n = reader.readInt();

        /*printAllPrimesLessThanEqualToN(n);*/
        /*getFirtNPrimeNumbers(n);*/
        /*boolean isPrim = checkIfNumberIsPrime(n);
        writer.print(n + " is " + (isPrim ? "prime" : "not prime"));*/

        writer.flush();
        writer.close();
    }

    public static void printAllPrimesLessThanEqualToN(int n) {
        boolean[] bool = new boolean[n + 1];
        Arrays.fill(bool, true);
        bool[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (bool[i]) {
                for (int j = i; j * i <= n; j++) {
                    bool[i*j]  = false;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (bool[i]) {
                count++;
                writer.print(i + " ");
            }
        }

        writer.printLine("\nTotal count = " + count);
    }

    public static int[] getFirtNPrimeNumbers(int n) {
        int maxVal = 10000000;
        boolean[] boolArr = new boolean[maxVal + 1];
        Arrays.fill(boolArr, true);
        boolArr[1] = false;

        for (int i = 2; i * i <= maxVal; i++) {
            if (boolArr[i]) {
                for (int j = i; j * i <= maxVal; j++) {
                    boolArr[i*j] = false;
                }
            }
        }

        int[] retArr = new int[n];
        int j = 0;
        int count = 0;
        for (int i = 2; i <= maxVal; i++) {
            if (boolArr[i]) {
                retArr[j] = i;
                j++;
                writer.print(i + " ");
                count++;
                if (count == n) {
                    break;
                }
            }
        }

        return retArr;
    }

    public static boolean checkIfNumberIsPrime(int n) {
        int[] firstRootNPrimeNumbers = getFirtNPrimeNumbers((int) (Math.round(Math.sqrt(n)) - 1));
        boolean isPrime = true;
        for (int i = 0; i < firstRootNPrimeNumbers.length; i++) {
            if (n % firstRootNPrimeNumbers[i] == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    public static boolean checkIfNumberIsPrimeEfficient(int n) {
        //check if n is a multiple of 2
        if (n == 1 || n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
