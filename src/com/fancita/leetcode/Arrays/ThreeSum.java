package com.fancita.leetcode.Arrays;

import java.util.*;

/**
 * Created by ashutosh on 18/1/17.
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0};
        System.out.println(Arrays.toString(new ThreeSum().threeSum(nums).toArray()));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0 || nums.length == 1 || nums.length == 2) return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>(nums.length);

        Set<Integer> set = new HashSet<>(nums.length);

        for (int i = 0; i < nums.length - 2; i++) {
            if (set.contains(nums[i])) continue;
            checkAndAddToList(nums, i, ret);
            set.add(nums[i]);
        }

        return ret;
    }

    private void checkAndAddToList(int[] nums, int leftMost, List<List<Integer>> ret) {
        int lastLeft = Integer.MAX_VALUE;
        int left = leftMost + 1, right = nums.length - 1;
        while (left < right) {

            int netSum = nums[leftMost] + nums[left] +  nums[right];

            if (netSum == 0 && nums[left] != lastLeft) {

                List<Integer> newL = new ArrayList<>(3);
                newL.add(nums[leftMost]);
                newL.add(nums[left]);
                newL.add(nums[right]);

                ret.add(newL);

                lastLeft = nums[left];

                left++;
                right--;
            } else if (netSum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}
