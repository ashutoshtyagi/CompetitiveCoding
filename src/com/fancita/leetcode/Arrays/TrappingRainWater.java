package com.fancita.leetcode.Arrays;

/**
 * Created by ashutosh on 5/2/17.
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TrappingRainWater().trap(arr));
    }

    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1 || height.length == 2) {
            return 0;
        }

        int[] leftMaxArr = new int[height.length];
        populateLeftMaxArr(leftMaxArr, height);

        int[] rightMaxArr = new int[height.length];
        populateRightMaxArr(rightMaxArr, height);

        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = leftMaxArr[i];
            int rightMax = rightMaxArr[i];
            int localTrap = Integer.min(leftMax, rightMax) - height[i];
            total += (localTrap > 0 ? localTrap : 0);
        }

        return total;
    }

    private void populateLeftMaxArr(int[] leftMax, int[] arr) {
        leftMax[0] = -1;
        int maxTillNow = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = maxTillNow;
            maxTillNow = Integer.max(maxTillNow, arr[i]);
        }
    }

    private void populateRightMaxArr(int[] rightMax, int[] arr) {
        rightMax[arr.length - 1] = -1;
        int maxTillNow = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMax[i] = maxTillNow;
            maxTillNow = Integer.max(maxTillNow, arr[i]);
        }
    }
}
