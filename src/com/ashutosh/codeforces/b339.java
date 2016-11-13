/*package com.ashutosh.codeforces;*/

import com.ashutosh.utils.FastIO;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by ashutosh on 11/11/16.
 */
public class b339 extends FastIO {

    public static void main(String[] args) {
        int n = reader.readInt();
        int m = reader.readInt();
        int[] arr = new int[m + 1];
        arr[0] = 1;
        IOUtils.readIntArray(reader, arr, 1);
        writer.printLine(getNoOfSteps(arr, n));
        writer.flush();
        writer.close();
    }

    private static long getNoOfSteps(int[] arr, int N) {
        long ret = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i-1]) {
                ret += arr[i] - arr[i-1];
            } else {
                ret += N + arr[i] - arr[i-1];
            }
        }
        return ret;
    }
}
