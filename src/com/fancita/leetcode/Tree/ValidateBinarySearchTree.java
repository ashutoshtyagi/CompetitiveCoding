package com.fancita.leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ashutosh on 5/1/17.
 */
public class ValidateBinarySearchTree {

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
        System.out.println(new ValidateBinarySearchTree().isValidBSTRecursive(root));
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
        System.out.println(new IterativeInorder().recursiveInorderTraversal(root));
    }

    public boolean isValidBST(TreeNode root) {
        TreeNode present = root;
        TreeNode previous = null;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || present != null) {
            if (present == null) {
                present = stack.removeFirst();
                if (previous != null) {
                    boolean compare = compare(present, previous);
                    if (!compare) {
                        return false;
                    }
                }
                previous = present;
                present = present.right;
            } else {
                stack.addFirst(present);
                present = present.left;
            }
        }

        return true;
    }

    private boolean compare(TreeNode present, TreeNode previous) {
        return previous.val < present.val;
    }

    public boolean isValidBSTRecursive(TreeNode root) {
        inorderTraversal(root, -1);
        return true;
    }

    private int inorderTraversal(TreeNode node, int number) {
        if (node == null) {
            return number;
        }

        if (node.left != null) {
            number = inorderTraversal(node.left, number);
        }

        System.out.println("number = " + number + " present = " +  node.val);
        number = node.val;

        if (node.right != null) {
            number = inorderTraversal(node.right, number);
        }

        return number;
    }
}
