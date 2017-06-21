package com.fancita.leetcode.Tree;

import java.util.*;

/**
 * Created by ashutosh on 18/1/17.
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(2);
        root.left = new TreeLinkNode(1);
        root.right = new TreeLinkNode(3);

        root.left.left = new TreeLinkNode(0);
        root.left.right = new TreeLinkNode(7);
        root.right.left = new TreeLinkNode(9);
        root.right.right = new TreeLinkNode(1);

        root.left.left.left = new TreeLinkNode(2);
        root.left.right.left = new TreeLinkNode(1);
        root.left.right.right = new TreeLinkNode(0);
        root.right.right.left = new TreeLinkNode(8);
        root.right.right.right = new TreeLinkNode(8);

        root.left.right.right.left = new TreeLinkNode(7);

        new PopulatingNextRightPointersInEachNodeII().connect(root);
        /*System.out.println(Arrays.toString(
                traverseRightwards(root).toArray()
        ));*/
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;

        Deque<TreeLinkNode> que = new ArrayDeque<>();
        que.addLast(root);

        while (!que.isEmpty()) {
            TreeLinkNode node = que.removeFirst();
            if (node.left != null) {
                node.left.next = getLeftChildContender(node);
                que.addLast(node.left);
            }
            if (node.right != null) {
                node.right.next = getRightChildContender(node);
                que.addLast(node.right);
            }
        }
    }

    private TreeLinkNode getLeftChildContender(TreeLinkNode parent) {
        if (parent.right != null) return parent.right;
        return getRightChildContender(parent);
    }

    private TreeLinkNode getRightChildContender(TreeLinkNode parent) {
        TreeLinkNode node = parent.next;
        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next;
        }
        return null;
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}
