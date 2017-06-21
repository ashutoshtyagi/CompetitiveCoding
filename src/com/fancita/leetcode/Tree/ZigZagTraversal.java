package com.fancita.leetcode.Tree;

import com.fancita.leetcode.Tree.TreeNode;

import java.util.*;

/**
 * Created by ashutosh on 5/1/17.
 */
public class ZigZagTraversal {
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
        System.out.println(Arrays.toString(new ZigZagTraversal().zigzagLevelOrder(root).toArray()));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ret = new ArrayList<>();

        Deque<TreeNode> leftToRightStack = new ArrayDeque<>();
        Deque<TreeNode> rightToLeftStack = new ArrayDeque<>();

        leftToRightStack.addFirst(root);

        while (!leftToRightStack.isEmpty()) {
            List<Integer> presentLevelLeftToRight = new ArrayList<>();
            while (!leftToRightStack.isEmpty()) {
                TreeNode presentNode = leftToRightStack.removeFirst();
                presentLevelLeftToRight.add(presentNode.val);
                if (presentNode.left != null) {
                    rightToLeftStack.addFirst(presentNode.left);
                }
                if (presentNode.right != null) {
                    rightToLeftStack.addFirst(presentNode.right);
                }
            }

            ret.add(presentLevelLeftToRight);

            if (!rightToLeftStack.isEmpty()) {
                List<Integer> presentLevelRightToLeft = new ArrayList<>();
                while (!rightToLeftStack.isEmpty()) {
                    TreeNode presentNode = rightToLeftStack.removeFirst();
                    presentLevelRightToLeft.add(presentNode.val);
                    if (presentNode.right != null) {
                        leftToRightStack.addFirst(presentNode.right);
                    }
                    if (presentNode.left != null) {
                        leftToRightStack.addFirst(presentNode.left);
                    }
                }
                ret.add(presentLevelRightToLeft);
            }
        }

        return ret;
    }
}
