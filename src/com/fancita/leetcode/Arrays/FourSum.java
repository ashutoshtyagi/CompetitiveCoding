package com.fancita.leetcode.Arrays;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by ashutosh on 16/1/17.
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {

    public static void main(String[] args) {
        /*int[] nums = new int[] {1,-2,-5,-4,-3,3,5,3};
        System.out.println(Arrays.toString(new FourSum().fourSum(nums, -11).toArray()));*/
        /*int[] nums = new int[] {-3, -2, -1, 0, 0, 1, 2, 3};*/
        int[] nums = new int[] {1, 0, -1, 0, -2, 2};
        System.out.println(Arrays.toString(new FourSum().fourSum(nums, 0).toArray()));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();

        int lastA = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - 4; i++) {
            if (nums[i] != lastA) {
                int a = nums[i];
                lastA = a;

                int lastB = Integer.MAX_VALUE;

                for (int j = i + 1; j <= nums.length - 3; j++) {
                    if (nums[j] != lastB) {
                        int b = nums[j];
                        lastB = b;
                        addToList(nums, j + 1, a, b, target, ret);
                    }
                }
            }
        }

        return ret;
    }

    private void addToList(int[] nums, int startingIndex, int a, int b, int target, List<List<Integer>> list) {
        int abSum = a + b;
        int i = startingIndex, j = nums.length - 1;

        int lastA = Integer.MAX_VALUE;

        while (i < j) {
            int indSum = nums[i] + nums[j] + abSum;
            if (indSum == target) {
                if (lastA != nums[i]) {

                    List<Integer> local = new ArrayList<>(4);
                    local.add(a);
                    local.add(b);
                    local.add(nums[i]);
                    local.add(nums[j]);
                    list.add(local);

                    lastA = nums[i];
                }
                i++;
                j--;
            }
            if (indSum < target) i++;
            else if (indSum > target) j--;
        }
    }
}
