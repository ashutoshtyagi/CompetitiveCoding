package com.fancita.codeforces;


import com.fancita.utils.FastIO;

/**
 * Created by ashutosh on 14/11/16.
 */
public class b363 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        int k = reader.readInt();
        int[] arr = IOUtils.readIntArray(reader, n);
        run(arr, n, k);
        writer.flush();
        writer.close();
    }

    public static void run(int[] arr, int n, int k) {

        int[] sumArr = new int[n];
        sumArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i-1] + arr[i];
        }

        int minSumTillNow = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i <= n-k; i++) {
            int j = i + k - 1;
            int sum = sumArr[j] - (i == 0 ? 0 : sumArr[i-1]);
            if (sum < minSumTillNow) {
                minSumTillNow = sum;
                index = i;
            }
        }

        writer.print(index + 1);
    }
}
