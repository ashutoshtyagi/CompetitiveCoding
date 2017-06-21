package com.fancita.leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ashutosh on 26/4/17.
 */
public class PrintTopView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(1);

        root.left.left.left = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(0);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(8);

        root.left.right.right.left = new TreeNode(7);
        root.left.right.right.left.left = new TreeNode(7);
        root.left.right.right.left.left.left = new TreeNode(7);
        root.left.right.right.left.left.left.left = new TreeNode(7);
        root.left.right.right.left.left.left.left.left = new TreeNode(7);
        root.left.right.right.left.left.left.left.left.left = new TreeNode(7);
        root.left.right.right.left.left.left.left.left.left.left = new TreeNode(7);
        root.left.right.right.left.left.left.left.left.left.left.left = new TreeNode(7);

        new PrintTopView().printTopView(root);
    }

    class Item {
        TreeNode node;
        int vertical;

        public Item(TreeNode node, int vertical) {
            this.node = node;
            this.vertical = vertical;
        }
    }

    private void  printTopView(TreeNode root) {
        if (root == null) return;

        Set<Integer> set = new HashSet<>();
        Deque<Item> que = new ArrayDeque<>();
        que.addLast(new Item(root, 0));

        while (!que.isEmpty()) {
            Item item = que.removeFirst();

            TreeNode node = item.node;

            if(!set.contains(item.vertical)) {
                System.out.println(node.val);
                set.add(item.vertical);
            }

            if (node.left != null) que.addLast(new Item(node.left, item.vertical - 1));
            if (node.right != null) que.addLast(new Item(node.right, item.vertical + 1));
        }
    }
}
