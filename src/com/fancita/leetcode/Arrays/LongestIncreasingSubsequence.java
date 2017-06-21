package com.fancita.leetcode.Arrays;

/**
 * Created by ashutosh on 23/2/17.
 * https://leetcode.com/problems/longest-increasing-subsequence/?tab=Description
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxDp = 1;

        for (int i = 1; i < nums.length; i++) {
            int localMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    localMax = localMax > (dp[j] + 1) ? localMax : (dp[j] + 1);
                }
            }
            dp[i] = localMax;
            maxDp = maxDp > localMax ? maxDp : localMax;
        }

        return maxDp;
    }
}
