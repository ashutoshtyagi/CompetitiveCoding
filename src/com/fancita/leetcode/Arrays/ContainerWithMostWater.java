package com.fancita.leetcode.Arrays;

/**
 * Created by ashutosh on 23/2/17.
 * https://leetcode.com/problems/container-with-most-water/?tab=Description
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[] {3, 4, 2, 1, 5};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }

    public int maxArea(int[] height) {
        int[] leftHighestIndex = new int[height.length];
        int[] rightHighestIndex = new int[height.length];

        populateLeftHighest(height, leftHighestIndex);
        populateRightHighest(height, rightHighestIndex);

        int maxTillNow = Integer.max(Integer.min(height[0], height[rightHighestIndex[0]]) * rightHighestIndex[0],
                Integer.min(height[height.length - 1], height[leftHighestIndex[height.length - 1]]) * (height.length - 1 - leftHighestIndex[height.length - 1]));
        for (int i = 1; i < height.length - 1; i++) {
            int leftHighIndex = leftHighestIndex[i];
            int rightHighIndex = rightHighestIndex[i];

            if (height[i] < height[leftHighIndex] && height[i] < height[rightHighIndex]) {
                maxTillNow = Integer.max(maxTillNow, Integer.min(height[leftHighIndex], height[rightHighIndex]) * (rightHighIndex - leftHighIndex));
            } else {
                maxTillNow = Integer.max(maxTillNow, Integer.min(height[leftHighIndex], height[i]) * (i - leftHighIndex));
                maxTillNow = Integer.max(maxTillNow, Integer.min(height[rightHighIndex], height[i]) * (rightHighIndex - i));
            }
        }

        return maxTillNow;
    }

    private void populateRightHighest(int[] height, int[] rightHighestIndex) {
        rightHighestIndex[height.length - 1] = Integer.MIN_VALUE;
        int maxIndexTillNow = height.length - 1;

        for (int i = height.length - 2; i >= 0; i--) {
            rightHighestIndex[i] = maxIndexTillNow;
            maxIndexTillNow = height[maxIndexTillNow] >= height[i] ?  maxIndexTillNow : i;
        }
    }

    private void populateLeftHighest(int[] height, int[] leftHighestIndex) {
        leftHighestIndex[0] = Integer.MIN_VALUE;
        int maxHeightIndexTillNow = 0;

        for (int i = 1; i < height.length; i++) {
            leftHighestIndex[i] = maxHeightIndexTillNow;
            maxHeightIndexTillNow = height[maxHeightIndexTillNow] >= height[i] ?  maxHeightIndexTillNow : i;
        }
    }
}
