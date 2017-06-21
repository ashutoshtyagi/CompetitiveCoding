package com.fancita.leetcode.Arrays;

import java.util.Arrays;

/**
 * Created by ashutosh on 18/1/17.
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 5};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 0 ||  nums.length == 1) return;

        int maxFromRight;
        for (maxFromRight = nums.length - 1; maxFromRight > 0; maxFromRight--) {
            if (nums[maxFromRight - 1] < nums[maxFromRight]) break;
        }

        if (maxFromRight == 0) {
            reverse(nums, 0);
        } else {
            /*swap(nums, maxFromRight - 1, maxFromRight);*/
            moveToPerfectPosition(nums, maxFromRight - 1);
            reverse(nums, maxFromRight);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void moveToPerfectPosition(int[] nums, int leftIncluding) {
        int target = nums[leftIncluding];
        int contender = leftIncluding +  1;
        for (int i = leftIncluding + 1; i < nums.length; i++) {
            if (nums[i] >= target) {
                contender = i;
            } else break;
        }
        swap(nums, leftIncluding, contender);
    }

    private void reverse(int[] nums, int leftIncluding) {
        int left = leftIncluding, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
