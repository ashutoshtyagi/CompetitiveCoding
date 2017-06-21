package com.fancita.leetcode.Tree;

import java.util.*;

/**
 * Created by ashutosh on 8/1/17.
 */
public class IterativePreorder {
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
        System.out.println(Arrays.toString(new IterativePreorder().preorderTraversal(root).toArray()));
        System.out.println(Arrays.toString(new IterativePreorder().recursivePreorderTraversal(root).toArray()));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        if (root != null) {
            stack.addFirst(root);
        }

        while (!stack.isEmpty()) {
            TreeNode pop = stack.removeFirst();
            ret.add(pop.val);
            if (pop.right != null) {
                stack.addFirst(pop.right);
            }
            if (pop.left != null) {
                stack.addFirst(pop.left);
            }
        }

        return ret;
    }

    public List<Integer> recursivePreorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        recurse(root, ret);
        return ret;
    }

    private void recurse(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        recurse(node.left, list);
        recurse(node.right, list);
    }
}
