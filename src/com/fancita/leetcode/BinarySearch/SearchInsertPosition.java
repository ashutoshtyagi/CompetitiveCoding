package com.fancita.leetcode.BinarySearch;

/**
 * Created by ashutosh on 1/2/17.
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5, 6};
        System.out.println(new SearchInsertPosition().searchInsert(arr, 10));
    }

    public int searchInsert(int[] arr, int target) {
        int contender = arr.length;

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid =  left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) {
                contender = Integer.min(contender, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return contender;
    }
}
