package com.fancita.codeforces;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by ashutosh on 25/12/16.
 */
public class div1b320 extends FastIO {
    public static void main(String[] args) {
        int n, k, x;
        n = reader.readInt();
        k = reader.readInt();
        x = reader.readInt();

        int product = 1;
        for (int i = 1; i <= k; i++) {
            product *= x;
        }

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.readInt();
            prefix[i] = i == 0 ? 0 : arr[i-1] | prefix[i-1];
            /*prefix[i] = arr[i] | (i == 0 ? 0 : prefix[i-1]);*/
        }

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = i == n-1 ? 0 : arr[i+1] | suffix[i+1];
            /*suffix[i] = arr[i] | (i == n - 1 ? 0 : suffix[i+1]);*/
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Long.max(ans, prefix[i] | ((long) arr[i] * product) | suffix[i]);
        }

        writer.printLine(ans);

        writer.flush();
        writer.close();
    }
}
