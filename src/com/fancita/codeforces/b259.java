package com.fancita.codeforces;

import com.fancita.utils.FastIO;

/**
 * Created by fancita on 10/11/16.
 */
public class b259 extends FastIO {

    public static void main(String[] args) {
        int N = reader.readInt();
        int[] arr = IOUtils.readIntArray(reader, N);
        writer.printLine(run(arr, N));
        writer.flush();
        writer.close();
    }

    public static int run(int[] arr, int N) {
        int ret = 0;

        int i = N-1;
        while (arr[0] == arr[i] && i > 0) {
            i--;
        }
        if (i == 0) {
            return 0;
        }

        if (arr[0] > arr[i]) {
            for (; i > 0 ; i--) {
                if (arr[i-1] > arr[i]) {
                    break;
                }
            }
            i--;
        }
        ret = N - 1 - i;

        boolean check = check(arr, 0, i);
        if (check) {
            return ret;
        } else return -1;
    }

    public static boolean check(int[] arr, int i, int j) {
        for (int k = i + 1; k <= j; k++) {
            if (arr[k] < arr[k-1]) {
                return false;
            }
        }
        return true;
    }
}
