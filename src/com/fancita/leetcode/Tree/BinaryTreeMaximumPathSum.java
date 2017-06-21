package com.fancita.leetcode.Tree;

/**
 * Created by ashutosh on 8/1/17.
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
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
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }

    private int maxTillNow;

    public int maxPathSum(TreeNode root) {
        maxTillNow = root == null ? 0 : root.val;
        recurse(root);
        return maxTillNow;
    }

    public int recurse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMaxSum = recurse(node.left);
        int rightMaxSum = recurse(node.right);

        // check max
        maxTillNow = Integer.max(maxTillNow, Integer.max(node.val, Integer.max(leftMaxSum + rightMaxSum + node.val,
                Integer.max(node.val + leftMaxSum, node.val + rightMaxSum))));

        return Integer.max(node.val + (leftMaxSum > rightMaxSum ? leftMaxSum : rightMaxSum), node.val);
    }
}
