package com.fancita.leetcode.BinarySearch;

import java.util.Arrays;

/**
 * Created by ashutosh on 16/1/17.
 * https://leetcode.com/problems/4sum-ii/
 */
public class FourSumII {
    public static void main(String[] args) {
        /*int[] A = new int[] {-1, -1};
        int[] B = new int[] {-1, 1};
        int[] C = new int[] {-1, 1};
        int[] D = new int[] {1, -1};*/
        int[] A = new int[] {1, 2};
        int[] B = new int[] {-2, -1};
        int[] C = new int[] {-1, 2};
        int[] D = new int[] {0, 2};
        System.out.println(new FourSumII().fourSumCount(A, B, C, D));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        if (n == 0) return 0;
        int[] arr1 = new int[n*n];
        int[] arr2 = new int[n*n];

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr1[k] = A[i] + B[j];
                k++;
            }
        }

        k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr2[k] = C[i] + D[j];
                k++;
            }
        }

        /*Arrays.sort(arr1);*/
        Arrays.sort(arr2);

        int ret = 0;
        for (int i = 0; i < n * n; i++) {
            int a1 = arr1[i];
            int right = binarySearchRight(arr2, -1 * a1);
            int left = binarySearchLeft(arr2, -1 * a1);
            if (right != -1) ret += right - left  + 1;
        }

        return ret;
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
