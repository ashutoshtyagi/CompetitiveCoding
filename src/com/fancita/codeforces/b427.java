package com.fancita.codeforces;

import com.fancita.utils.FastIO;

/**
 * Created by fancita on 13/11/16.
 */
public class b427 extends FastIO {

    public static void main(String[] args) {
        int n = reader.readInt();
        int maxSeverity = reader.readInt();
        int k = reader.readInt();
        int[] arr = IOUtils.readIntArray(reader, n);
        run(arr, maxSeverity, k);
        writer.flush();
        writer.close();
    }

    public static void run(int[] arr, int maxSeverity, int k) {
        int i = 0;
        int ret = 0;
        int j = 0;
        for (j = 0; j < arr.length; j++) {
            if (arr[j] > maxSeverity) {
                int addedSum = j - i - k + 1;
                ret += addedSum > 0 ? addedSum : 0;
                i = j + 1;
            }
        }
        if (i <= j) {
            int addedSum = j - i - k + 1;
            ret += addedSum > 0 ? addedSum : 0;
        }
        writer.print(ret);
    }
}