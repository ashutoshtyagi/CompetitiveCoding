package com.fancita.leetcode.Tree;

import java.util.*;

/**
 * Created by ashutosh on 4/1/17.
 */
public class IterativeInorder {

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
        System.out.println(Arrays.toString(new IterativeInorder().inorderTraversal(root).toArray()));
        System.out.println(Arrays.toString(new IterativeInorder().recursiveInorderTraversal(root).toArray()));
    }

    public List<Integer> recursiveInorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        recurse(root, ret);
        return ret;
    }

    public void recurse(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        recurse(node.left, list);
        list.add(node.val);
        recurse(node.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        TreeNode present = root;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || present != null) {
            if (present == null) {
                TreeNode stackTop = stack.removeFirst();
                ret.add(stackTop.val);
                present = stackTop.right;
            } else {
                stack.addFirst(present);
                present = present.left;
            }
        }

        return ret;
    }
}
