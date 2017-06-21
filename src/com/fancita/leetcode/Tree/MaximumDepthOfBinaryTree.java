package com.fancita.leetcode.Tree;

/**
 * Created by ashutosh on 8/12/16.
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root));
    }

    public int maxDepth(TreeNode treeNode) {
        return treeNode == null ? 0 : 1 + Integer.max(maxDepth(treeNode.left), maxDepth(treeNode.right));
    }
}
