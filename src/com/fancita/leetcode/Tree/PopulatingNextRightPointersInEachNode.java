package com.fancita.leetcode.Tree;

/**
 * Created by ashutosh on 18/1/17.
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {

    }

    public void connect(TreeLinkNode node) {
        if (node == null) return;
        if (node.left == null) return;

        node.left.next = node.right;

        if (node.right != null && node.next != null && node.next.left != null) {
            node.right.next = node.next.left;
        }

        connect(node.left);
        connect(node.right);
    }

    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}

