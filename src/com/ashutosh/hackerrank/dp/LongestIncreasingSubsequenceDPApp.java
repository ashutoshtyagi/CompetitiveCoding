package com.ashutosh.hackerrank.dp;

import java.util.Scanner;

/**
 * Created by ashutosh on 23/10/16.
 * https://www.hackerrank.com/challenges/longest-increasing-subsequent
 */
public class LongestIncreasingSubsequenceDPApp {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int sizeOfArray = reader.nextInt();

        int[] arr = new int[sizeOfArray];
        int arrIt = 0; // array Iterator

        int LISOfWholeArray = 0;
        int[] LISArrElement = new int[sizeOfArray];

        for (arrIt = 0; arrIt < sizeOfArray; arrIt++) {
            int element = reader.nextInt();
            arr[arrIt] = element;

            // because even if the present element is the smallest of all bedore it,
            // it has LIS of 1, which will entail itself
            int maxUpTilNowIncludingPresentElement = 1;
            for (int i = 0; i < arrIt; i++) {
                // >= for longest increasing, > for longest strictly increasing
                if (element > arr[i]) {
                    maxUpTilNowIncludingPresentElement =
                            Integer.max(maxUpTilNowIncludingPresentElement, LISArrElement[i] + 1);
                }
            }

            LISArrElement[arrIt] = maxUpTilNowIncludingPresentElement;
            LISOfWholeArray = Integer.max(LISOfWholeArray, LISArrElement[arrIt]);
        }

        System.out.println(LISOfWholeArray);
    }
}
