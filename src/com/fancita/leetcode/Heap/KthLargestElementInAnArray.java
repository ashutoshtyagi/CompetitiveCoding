package com.fancita.leetcode.Heap;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by ashutosh on 10/2/17.
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Integer[] intclassArr = new Integer[] {5,6,7,8,4,3,2,5,7,9,0,2,5,1};
        Arrays.sort(intclassArr, Collections.reverseOrder());
        System.out.println(Arrays.toString(intclassArr));

        int[] arr = new int[] {5,6,7,8,4,3,2,5,7,9,0,2,5,1};
        System.out.println(new KthLargestElementInAnArray().findKthLargest(arr, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        if (k == 0) return -1;

        IntegerMinHeap minHeap = new IntegerMinHeap(k);

        int kIter = 1;

        for (int i = 0; i < nums.length; i++) {
            if (kIter <= k) {
                kIter++;
                minHeap.add(nums[i]);
                continue;
            }

            int present = nums[i];
            if (present > minHeap.viewMin()) {
                minHeap.replaceMin(present);
            }
        }

        return minHeap.viewMin();
    }
}
