package com.fancita.leetcode.BinarySearch;

/**
 * Created by ashutosh on 19/1/17.
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[] {/*4, 5, 6,*/ 7, 0, 1, 2};
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(arr));
    }

    public int findMin(int[] arr) {
        if (arr.length == 0) return Integer.MIN_VALUE;
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return Integer.min(arr[0], arr[1]);

        int contender = Integer.MAX_VALUE;
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= arr[right]) {
                contender = Integer.min(contender, arr[mid]);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return contender;
    }
}
