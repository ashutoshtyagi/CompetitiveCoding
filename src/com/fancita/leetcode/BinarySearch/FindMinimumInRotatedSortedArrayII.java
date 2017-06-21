package com.fancita.leetcode.BinarySearch;

/**
 * Created by ashutosh on 19/1/17.
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        /*int[] arr = new int[] {4, 5, 6, 7, 0, 1, 2};*/
        /*int[] arr = new int[] {2, 2, 2, 2, 2, 2, 2, 1, 2, 2};*/
        int[] arr = new int[] {3, 3, 1, 3};
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(arr));
    }

    public int findMin(int[] arr) {
        if (arr.length == 0) return Integer.MAX_VALUE;
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return Integer.min(arr[0], arr[1]);

        int contender = Integer.MAX_VALUE;
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[right]) {
                contender = Integer.min(contender, arr[mid]);
                right = mid - 1;

            } else if (arr[mid] > arr[right]) {
                left = mid + 1;

            } else {
                contender = Integer.min(contender, arr[mid]);

                if (arr[left] == arr[mid]) {
                    contender = Integer.min(contender, binarySearch(arr, mid + 1, right));
                    contender = Integer.min(contender, binarySearch(arr, left, mid - 1));
                    break;
                } else {
                    right = mid - 1;
                }
            }
        }

        return contender;
    }

    private int binarySearch(int[] arr, int left, int right) {
        if (left > right) return Integer.MAX_VALUE;
        if (left == right) return arr[left];
        if (right - left == 1) return Integer.min(arr[left], arr[right]);

        int contender = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[right]) {
                contender = Integer.min(contender, arr[mid]);
                right = mid - 1;

            } else if (arr[mid] > arr[right]) {
                left = mid + 1;

            } else {
                contender = Integer.min(contender, arr[mid]);

                if (arr[left] == arr[mid]) {
                    contender = Integer.min(contender, binarySearch(arr, mid + 1, right));
                    contender = Integer.min(contender, binarySearch(arr, left, mid - 1));
                    break;
                } else {
                    right = mid - 1;
                }
            }
        }

        return contender;
    }
}
