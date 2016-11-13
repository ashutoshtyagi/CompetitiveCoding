package com.fancita.practice.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fancita on 23/10/16.
 */
public class LongestIncreasingSubsequenceBinarySearchApp {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int lengthOfInput = reader.nextInt();

        int[] sortedArr = new int[lengthOfInput];
        sortedArr[0] = reader.nextInt();
        int sortedArrIterator = 0;

        for (int i = 1; i < lengthOfInput; i++) {
            int element = reader.nextInt();

            if (element > sortedArr[sortedArrIterator]) {
                sortedArrIterator++;
                sortedArr[sortedArrIterator] = element;
            } else if (element < sortedArr[sortedArrIterator]) {
                replaceElementOfArray(sortedArr, 0, sortedArrIterator, element);
            }
            System.out.println(Arrays.toString(sortedArr));
        }

        System.out.print(++sortedArrIterator);
    }

    public static void replaceElementOfArray(int[] arr, int firstIndexOfArr, int lastIndexOfArr, int element) {
        if (lastIndexOfArr == firstIndexOfArr) {
            arr[firstIndexOfArr] = element;
            return;
        }

        int mid = firstIndexOfArr + ((lastIndexOfArr - firstIndexOfArr) / 2);
        if (element < arr[mid]) {
            replaceElementOfArray(arr, firstIndexOfArr, mid, element);
        } else {
            replaceElementOfArray(arr, mid + 1, lastIndexOfArr, element);
        }
        return;
    }
}
