package com.fancita.codeforces;

import com.fancita.utils.FastIO;

/**
 * Created by fancita on 11/11/16.
 */
public class b538 extends FastIO {

    public static void main(String[] args) {
        int k = reader.readInt();
        run(k);
        writer.flush();
        writer.close();
    }

    public static void run(int k) {
        int arr[] = new int[10];

        int t = 1;
        int maxNo = 0;
        while (k > 0) {
            int rem = k % 10;
            maxNo = Integer.max(maxNo, rem);
            for (int i = 0; i < rem; i++) {
                arr[i] += t;
            }
            t *= 10;
            k /= 10;
        }

        writer.printLine(maxNo);
        for (int i = 0; i < maxNo; i++) {
            writer.print(arr[i] + " ");
        }
    }
}

