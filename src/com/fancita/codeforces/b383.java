package com.fancita.codeforces;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by ashutosh on 16/12/16.
 */
public class b383 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        int x = reader.readInt();
        int[] arr = IOUtils.readIntArray(reader, n);
        /*solveBF(arr, x);
        writer.printLine("now my solution");*/
        solve(arr, x);
        writer.flush();
        writer.close();
    }

    public static void solveBF(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i +  1; j < arr.length; j++) {
                if ((arr[i] ^ arr[j]) == x) {
                    writer.printLine("equal at " + arr[i] + ", " +  arr[j]);
                }
            }
        }
    }

    public static void solve(int[] arr, int x) {
        Arrays.sort(arr);
        /*writer.printLine(Arrays.toString(arr));*/
        if (x == 0) {
            writer.printLine(calculateDistinctNumbers(arr));
            return;
        }
        long ret = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftIndex = binarySearchLeftIndex(arr, x ^ arr[i], 0, arr.length - 1);
            int rightIndex = binarySearchRightIndex(arr, x ^ arr[i], 0, arr.length - 1);
            ret += leftIndex >= 0 ? rightIndex - leftIndex + 1 : 0;
            /*boolean check = binarySearchContains(arr, x ^ arr[i], 0, arr.length - 1);
            if (check) writer.printLine("equal at " + arr[i] + ", " +  (x ^ arr[i]));
            ret += check ? 1 : 0;*/
        }
        writer.printLine(ret/2);
    }

    public static long calculateDistinctNumbers(int[] arr) {
        long ret = 0;
        int lastNo = arr[0];
        int lastRepeatCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != lastNo) {
                ret += efficientBinomialCoefficient(lastRepeatCount, 2);
                lastRepeatCount = 1;
                lastNo = arr[i];
                continue;
            }
            lastRepeatCount++;
        }
        return ret + (long) efficientBinomialCoefficient(lastRepeatCount, 2);
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

    public static int binarySearchLeftIndex(int[] sortedArr, int numberToFind, int i, int j) {
        if (i > j) {
            return -1;
        }
        if (i == j) {
            return sortedArr[i] == numberToFind ? i : -1;
        }
        int mid = i + (j - i) / 2;
        if (sortedArr[mid] == numberToFind) {
            return binarySearchLeftIndex(sortedArr, numberToFind, i, mid);
        } else if (sortedArr[mid] < numberToFind) {
            return binarySearchLeftIndex(sortedArr, numberToFind, mid + 1, j);
        } else /*if (sortedArr[mid] > numberToFind)*/ {
            return binarySearchLeftIndex(sortedArr, numberToFind, i, mid - 1);
        }
    }

    public static int binarySearchRightIndex(int[] sortedArr, int numberToFind, int i, int j) {
        if (i > j) {
            return -1;
        }
        if (i == j) {
            return sortedArr[i] == numberToFind ? i : -1;
        }
        if (j - i == 1) {
            return sortedArr[j] == numberToFind ? j : sortedArr[i] == numberToFind ? i : -1;
        }
        int mid = i + (j - i) / 2;
        if (sortedArr[mid] == numberToFind) {
            return binarySearchRightIndex(sortedArr, numberToFind, mid, j);
        } else if (sortedArr[mid] < numberToFind) {
            return binarySearchRightIndex(sortedArr, numberToFind, mid + 1, j);
        } else /*if (sortedArr[mid] > numberToFind)*/ {
            return binarySearchRightIndex(sortedArr, numberToFind, i, mid - 1);
        }
    }

    public static boolean binarySearchContains(int[] sortedArr, int numberToFind, int i, int j) {
        if (i > j) {
            return false;
        }
        if (i == j) {
            return sortedArr[i] == numberToFind ? true : false;
        }
        int mid = i + (j - i) / 2;
        if (sortedArr[mid] == numberToFind) {
            return true;
        } else if (sortedArr[mid] < numberToFind) {
            return binarySearchContains(sortedArr, numberToFind, mid + 1, j);
        } else /*if (sortedArr[mid] > numberToFind)*/ {
            return binarySearchContains(sortedArr, numberToFind, i, mid - 1);
        }
    }
}

