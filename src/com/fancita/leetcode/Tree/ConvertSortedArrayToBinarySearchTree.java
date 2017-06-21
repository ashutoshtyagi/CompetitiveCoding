package com.fancita.leetcode.Tree;

/**
 * Created by ashutosh on 13/1/17.
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] sortedArr = new int[] {1,3};
        TreeNode ret = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(sortedArr);
        System.out.println(new IterativeInorder().recursiveInorderTraversal(ret));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;

        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int mid = left + (right - left) / 2;
        TreeNode ret = new TreeNode(nums[mid]);
        ret.left = sortedArrayToBST(nums, left, mid - 1);
        ret.right = sortedArrayToBST(nums, mid + 1, right);
        return ret;
    }
}
