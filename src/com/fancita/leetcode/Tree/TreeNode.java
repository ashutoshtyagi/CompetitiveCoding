package com.fancita.leetcode.Tree;

/**
 * Created by ashutosh on 8/12/16.
 */
public class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}