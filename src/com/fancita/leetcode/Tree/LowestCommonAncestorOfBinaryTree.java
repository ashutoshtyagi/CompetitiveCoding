package com.fancita.leetcode.Tree;

/**
 * Created by ashutosh on 5/2/17.
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(1);

        root.left.left.left = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(0);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(8);

        root.left.right.right.left = new TreeNode(7);

        System.out.println(new LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, root.left, root.left.right).toString());
    }

    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) return node;
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        return left == null ? right : right == null ? left : node;
    }
}
