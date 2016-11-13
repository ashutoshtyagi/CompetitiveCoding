package com.ashutosh.codechef.long_november;

import com.ashutosh.utils.FastIO;

/**
 * Created by ashutosh on 10/11/16.
 * https://www.codechef.com/NOV16/problems/ALEXTASK
 */
public class ALEXTASK extends FastIO {

    public static void main(String[] args) {
        int t = reader.readInt();
        while (t-- > 0) {
            int n = reader.readInt();
            int[] arr = IOUtils.readIntArray(reader, n);
            writer.printLine(new ALEXTASK(arr).run());
        }
        writer.flush();
        writer.close();
    }


    private int[] arr;
    private int N;
    public ALEXTASK(int[] arr) {
        this.arr = arr;
        this.N = arr.length;
    }

    public int run() {
        int minLcm = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                minLcm = Integer.min(lcm(arr[i], arr[j]), minLcm);
            }
        }
        return minLcm;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) { return a * (b / gcd(a, b)); }
}
