package com.fancita.codeforces;

import com.fancita.utils.FastIO;

/**
 * Created by ashutosh on 14/11/16.
 */
public class b368 extends FastIO {

    public static void main(String[] args) {
        int n = reader.readInt();
        int m = reader.readInt();
        int[] arr = new int[n+1];
        IOUtils.readIntArray(reader, arr, 1);
        run(arr, n, m);
        writer.flush();
        writer.close();
    }

    public static void run(int[] arr, int n, int m) {
        /* n is not the size, but last index of arr */
        int[] countArr = new int[n+1];
        boolean[] visitedArr = new boolean[100001];
        countArr[n] = 1;
        visitedArr[arr[n]] = true;
        for (int i = n - 1; i > 0; i--) {
            if (visitedArr[arr[i]]) {
                countArr[i] = countArr[i+1];
            } else {
                countArr[i] = countArr[i+1] + 1;
                visitedArr[arr[i]] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            int query = reader.readInt();
            writer.printLine(countArr[query]);
        }
    }
}
