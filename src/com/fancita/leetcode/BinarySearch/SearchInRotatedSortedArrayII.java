package com.fancita.leetcode.BinarySearch;

/**
 * Created by ashutosh on 19/1/17.
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 2, 1, 1, 2, 2, 2, 2, 2, 2};
        System.out.println(new SearchInRotatedSortedArrayII().search(arr, 2));
    }

    public boolean search(int[] arr, int target) {
        if (arr.length == 0) return false;
        if (arr.length == 1) return arr[0] == target;

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left  + (right - left) / 2;

            if (arr[mid] == target) return true;

            if (left == right) break;

            if (arr[mid] < arr[right]) {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (arr[mid] > arr[right]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] == arr[left]) {
                    boolean searchLeft = searchRecurse(arr, target, left + 1, mid - 1);
                    if (searchLeft == true) return true;
                    return searchRecurse(arr, target, mid + 1, right - 1);
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public boolean searchRecurse(int[] arr, int target, int left, int right) {
        if (left > right) return false;
        if (left == right) return arr[left] == target;

        while (left <= right) {
            int mid = left  + (right - left) / 2;

            if (arr[mid] == target) return true;

            if (left == right) break;

            if (arr[mid] < arr[right]) {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (arr[mid] > arr[right]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] == arr[left]) {
                    boolean searchLeft = searchRecurse(arr, target, left + 1, mid - 1);
                    if (searchLeft == true) return searchLeft;
                    return searchRecurse(arr, target, mid + 1, right - 1);
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
