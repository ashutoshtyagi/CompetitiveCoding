package com.fancita.codeforces;

import com.fancita.utils.FastIO;

import java.util.Arrays;

/**
 * Created by fancita on 12/11/16.
 */
public class b327 extends FastIO {

    public static void main(String[] args) {
        int n = reader.readInt();

        getFirtNPrimeNumbers(n);

        writer.flush();
        writer.close();
    }

    public static void getFirtNPrimeNumbers(int n) {
        int maxVal = 10000000;
        boolean[] boolArr = new boolean[maxVal + 1];
        Arrays.fill(boolArr, true);
        boolArr[1] = false;

        for (int i = 2; i * i <= maxVal; i++) {
            if (boolArr[i]) {
                for (int j = i; j * i <= maxVal; j++) {
                    boolArr[i*j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= maxVal; i++) {
            if (boolArr[i]) {
                writer.print(i + " ");
                count++;
                if (count == n) {
                    break;
                }
            }
        }
    }
}