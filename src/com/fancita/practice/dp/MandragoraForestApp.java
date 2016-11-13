package com.fancita.practice.dp;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fancita on 18/10/16.
 */
public class MandragoraForestApp {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int t = reader.nextInt();
        while (t > 0) {
            t--;

            int sizeOfArray = reader.nextInt();
            int[] inputArr = new int[sizeOfArray];
            int inputIter = sizeOfArray;
            while (inputIter > 0) {
                inputArr[--inputIter] = reader.nextInt();
            }
            //System.out.println(Arrays.toString(inputArr));
            Arrays.sort(inputArr);
            //System.out.println(Arrays.toString(inputArr));

            sizeOfArray = inputArr.length;

            BigInteger[] sumArrReverseOrder = new BigInteger[sizeOfArray];
            for (int i = sizeOfArray - 1; i >= 0; i--) {
                BigInteger presentNumber = BigInteger.valueOf(inputArr[i]);
                if (i == sizeOfArray - 1) {
                    sumArrReverseOrder[i] = presentNumber;
                } else {
                    sumArrReverseOrder[i] = sumArrReverseOrder[i + 1].add(presentNumber);
                }
            }
            //System.out.println(Arrays.toString(sumArrReverseOrder));

            BigInteger maxTillNow = BigInteger.valueOf(Integer.MIN_VALUE);
            for (int i = -1; i < sizeOfArray; i++) {
                int s = 1 +  (i + 1);
                BigInteger h;
                if (i == sizeOfArray - 1) {
                    h = BigInteger.ZERO;
                } else {
                    h = BigInteger.valueOf(s).multiply(sumArrReverseOrder[i + 1]);
                }
                maxTillNow = maxTillNow.max(h);
            }

            System.out.println(maxTillNow);
        }
    }
}
