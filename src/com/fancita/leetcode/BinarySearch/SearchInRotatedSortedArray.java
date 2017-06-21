package com.fancita.leetcode.BinarySearch;

/**
 * Created by ashutosh on 19/1/17.
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        /*int[] arr = new int[] {4, 5, 6, 7, 0, 1, 2};*/
        int[] arr = new int[] {7, 6/*, 5, 4*/};
        System.out.println(new SearchInRotatedSortedArray().search(arr, 6));
    }

    public int search(int[] arr, int target) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0] == target ? 0 : -1;

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left  + (right - left) / 2;

            if (arr[mid] == target) return mid;

            if (left == right) break;

            if (arr[mid] < arr[right]) {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
