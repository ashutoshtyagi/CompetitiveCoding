package com.fancita.leetcode.BinarySearch;

import java.util.Arrays;

/**
 * Created by ashutosh on 13/1/17.
 */
public class SearchForARange {
    public static void main(String[] args) {
        int[] nums =  new int[] {5, 7, 7, 8, 8, 10};
        int[] ret = new SearchForARange().searchRange(nums, 1);
        System.out.println(Arrays.toString(ret));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = binarySearchLeft(nums, target);
        if (left == -1) {
            return new int[]{-1, -1};
        }

        int right = binarySearchRight(nums, target);
        return new int[] {left, right};
    }

    private int binarySearchLeft(int[] nums, int target) {
        int contender = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                contender = mid;
                right = mid - 1;
            }
        }

        return contender;
    }

    private int binarySearchRight(int[] nums, int target) {
        int contender = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                contender = mid;
                left = mid + 1;
            }
        }

        return contender;
    }
}
