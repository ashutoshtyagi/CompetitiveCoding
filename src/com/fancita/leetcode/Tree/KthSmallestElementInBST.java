package com.fancita.leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ashutosh on 5/2/17.
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(new KthSmallestElementInBST().kthSmallest(root, 8));
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;

        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

        addNodesToStack(stack, root);

        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();

            count++;
            if (count == k) return node.val;

            if (node.right == null) continue;
            addNodesToStack(stack, node.right);
        }

        return -1;
    }

    private void addNodesToStack(Deque<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.addFirst(node);
            node = node.left;
        }
    }
}
