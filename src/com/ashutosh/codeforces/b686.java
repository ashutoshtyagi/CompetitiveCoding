package com.ashutosh.codeforces;

import com.ashutosh.utils.FastIO;

/**
 * Created by ashutosh on 12/11/16.
 */
public class b686 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        int[] arr = IOUtils.readIntArray(reader, n);
        run(arr, n);
        writer.flush();
        writer.close();
    }

    public static void run(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    /*Utils.*/swipe(arr, j-1, j);
                    writer.printLine((j) + " " + (j + 1));
                }
            }
        }
    }

    public static void swipe(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}