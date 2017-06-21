package com.fancita.practice.Sort;


import com.fancita.utils.FastIO;

import java.util.Arrays;

/**
 * Created by ashutosh on 1/12/16.
 */
public class MergeSort extends FastIO.IOUtils {
    public static void main(String[] args) {
        int arr[] = {7,6,9,4,3,7,65,2,3,9,5};
        mergeSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        int[] aux = new int[arr.length];
        sort(arr, 0, arr.length - 1, aux);
        return;
    }

    private static void sort(int[] inp, int low, int high, int[] aux) {
        if (low == high) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(inp, low, mid, aux);
        sort(inp, mid + 1, high, aux);
        merge(inp, low, mid, high, aux);
    }

    private static void merge(int[] inp, int low, int mid, int high, int[] aux) {
        int k = low, l = mid + 1, m = 0;
        while (k <= mid && l <= high) {
            if (inp[k] <= inp[l]) {
                aux[m] = inp[k];
                m++;
                k++;
            } else {
                aux[m] = inp[l];
                m++;
                l++;
            }
        }

        if (k == mid + 1 && l <= high) {  // in this case, rest of aux must be filled with second half of inp
            while (l <= high) {
                aux[m] = inp[l];
                m++;
                l++;
            }
        } else if (k <= mid && l == high + 1) {
            while (k <= mid) {
                aux[m] = inp[k];
                m++;
                k++;
            }
        }

        // eventually, m is the size of the aux array
        int inpIter = low;
        for (int i = 0; i < m; i++) {
            inp[inpIter] = aux[i];
            inpIter++;
        }
    }
}
