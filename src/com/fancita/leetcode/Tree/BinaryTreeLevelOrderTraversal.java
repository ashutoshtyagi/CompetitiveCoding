package com.fancita.leetcode.Tree;

import java.util.*;

/**
 * Created by ashutosh on 11/1/17.
 */
public class BinaryTreeLevelOrderTraversal {
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
        System.out.println(Arrays.toString(new BinaryTreeLevelOrderTraversal().levelOrder(root).toArray()));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ret = new ArrayList<>();

        Deque<TreeNode> queue1 =  new ArrayDeque<>();
        queue1.addLast(root);

        Deque<TreeNode> queue2 =  new ArrayDeque<>();

        while (!queue1.isEmpty()) {

            List<Integer> q1List = new ArrayList<>();

            while (!queue1.isEmpty()) {

                TreeNode node = queue1.removeFirst();

                q1List.add(node.val);

                if (node.left != null) queue2.addLast(node.left);

                if (node.right != null) queue2.addLast(node.right);
            }

            ret.add(q1List);

            if (!queue2.isEmpty()) {
                List<Integer> q2List = new ArrayList<>();

                while (!queue2.isEmpty()) {

                    TreeNode node = queue2.removeFirst();

                    q2List.add(node.val);

                    if (node.left != null) queue1.addLast(node.left);

                    if (node.right != null) queue1.addLast(node.right);
                }

                ret.add(q2List);
            }
        }

        return ret;
    }
}
