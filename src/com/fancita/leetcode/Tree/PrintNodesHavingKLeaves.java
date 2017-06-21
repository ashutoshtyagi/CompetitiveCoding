package com.fancita.leetcode.Tree;

/**
 * Created by ashutosh on 7/3/17.
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700465
 */
public class PrintNodesHavingKLeaves {

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

        new PrintNodesHavingKLeaves().btWithKleaves(root, 2);
    }

    public void btWithKleaves(TreeNode root, int k) {
        StringBuilder printString = new StringBuilder();
        recurse(root, k, printString);
        if (printString.equals("")) System.out.println("-1");
        else System.out.println(printString.toString());
    }

    private int recurse(TreeNode node, int k, StringBuilder printString) {
        if (node == null) return 0;
        if (node.left == null &&  node.right == null) return 1;

        int left = recurse(node.left, k, printString);
        int right = recurse(node.right, k, printString);

        if (left + right == k) printString.append(node.val + " ");

        return left + right;
    }
}
