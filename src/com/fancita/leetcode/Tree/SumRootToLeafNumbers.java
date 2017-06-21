package com.fancita.leetcode.Tree;

/**
 * Created by ashutosh on 8/1/17.
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {
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
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return recurse(root, 0);
    }

    private int recurse(TreeNode node, int numberTillNow) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return numberTillNow * 10 + node.val;
        }

        int left = recurse(node.left, numberTillNow * 10 + node.val);
        int right = recurse(node.right, numberTillNow * 10 + node.val);

        return left + right;
    }
}
