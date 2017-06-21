package com.fancita.codeforces;

import com.fancita.utils.FastIO;

import java.util.Arrays;

/**
 * Created by ashutosh on 13/11/16.
 */
public class b546 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        int[] arr = IOUtils.readIntArray(reader, n);
        run(arr, n);
        writer.flush();
        writer.close();
    }

    public static void run(int[] arr, int n) {
        Arrays.sort(arr);
        /*writer.printLine(Arrays.toString(arr));*/
        int ret = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] >= arr[i]) {
                int diff = arr[i-1] - arr[i] + 1;
                ret += diff;
                arr[i] += diff;
            }
        }
        writer.print(ret);
    }
}
