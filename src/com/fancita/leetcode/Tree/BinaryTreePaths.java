package com.fancita.leetcode.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ashutosh on 13/1/17.
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {
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
        System.out.println(Arrays.toString(new BinaryTreePaths().binaryTreePaths(root).toArray()));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        recurse(root, stringBuilder, ret);
        return ret;
    }

    private void recurse(TreeNode node, StringBuilder stringBuilder, List<String> ret) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            stringBuilder.append(node.val);
            ret.add(stringBuilder.toString());
            stringBuilder.delete(stringBuilder.lastIndexOf(String.valueOf(node.val)), stringBuilder.length());
            return;
        }

        stringBuilder.append(String.valueOf(node.val) + "->");
        recurse(node.left, stringBuilder, ret);
        recurse(node.right, stringBuilder, ret);

        stringBuilder.delete(stringBuilder.lastIndexOf(String.valueOf(node.val)), stringBuilder.length());
        return;
    }
}
