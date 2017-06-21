package com.fancita.leetcode.Tree;

import java.util.*;

/**
 * Created by ashutosh on 18/1/17.
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(Arrays.toString(new BinaryTreeRightSideView().rightSideView(root).toArray()));
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Map<Integer, Integer> map = new HashMap<>();

        preorder(root, 0, map);

        return new ArrayList<>(map.values());
    }

    private void preorder(TreeNode node, int height, Map<Integer, Integer> map) {
        if (node == null) return;

        map.put(height, node.val);
        preorder(node.left, height + 1, map);
        preorder(node.right, height + 1, map);
    }
}
