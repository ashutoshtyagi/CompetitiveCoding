package com.fancita.leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ashutosh on 10/1/17.
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
public class SerializeDeserializeBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        /*root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);*/
        SerializeDeserializeBST codec = new SerializeDeserializeBST();
        System.out.println(codec.serialize(root));
        System.out.println(codec.serialize(codec.deserialize(codec.serialize(root))));
    }

    public String serialize(TreeNode root) {
        int height = getHeight(root);

        StringBuilder sb = new StringBuilder( 2^(height+1) -1);
        return null;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Integer.max(getHeight(node.left), getHeight(node.right));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr.length == 0 || (arr.length == 1 && arr[0].trim().equals("null"))) {
            return null;
        }

        Deque<TreeNode> queue = new ArrayDeque<>(arr.length);
        TreeNode root = new TreeNode(Integer.valueOf(arr[0].trim()));
        queue.addLast(root);

        for (int i = 0; i < arr.length; i++) {
            String nodeVal = arr[i];
            if (nodeVal.equals("null")) {
                continue;
            }

            TreeNode present = queue.removeFirst();

            int leftChildIndex = 2*i + 1;
            if (leftChildIndex < arr.length) {
                String leftChildVal = arr[leftChildIndex];
                if (!leftChildVal.equals("null")) {
                    TreeNode leftChild = new TreeNode(Integer.valueOf(leftChildVal));
                    present.left = leftChild;
                    queue.addLast(leftChild);
                }
            }

            int rightChildIndex = 2*i + 2;
            if (rightChildIndex < arr.length) {
                String rightChildVal = arr[rightChildIndex];
                if (!rightChildVal.equals("null")) {
                    TreeNode rightChild = new TreeNode(Integer.valueOf(rightChildVal));
                    present.right = rightChild;
                    queue.addLast(rightChild);
                }
            }
        }

        return root;
    }

    // Encodes a tree to a single string.
    /*public String serialize(TreeNode root) {
        // level order traversal
        StringBuilder ret = new StringBuilder();

        Deque<TreeNode> que = new ArrayDeque<>();

        if (root == null) {
            ret.append("null");
            return ret.toString();
        } else {
            que.addLast(root);
        }

        int maxCount = 1, countTillNow = 0, lastLevel = 1;

        while (!que.isEmpty()) {

            TreeNode head = que.pollFirst();

            countTillNow++;

            int nextLevelToAdd = -1;

            if (head.left == null) {
                TreeNode node = new TreeNode(-1);
                que.addLast(node);
            } else {
                int leftChildPos = 2 * countTillNow;
                nextLevelToAdd = (int) Math.floor((Math.log(leftChildPos) / Math.log(2)) + 1);
                que.addLast(head.left);
            }

            if (head.right == null) {
                TreeNode node = new TreeNode(-1);
                que.addLast(node);
            } else {
                int rightChildPos = 2 * countTillNow + 1;
                nextLevelToAdd = (int) Math.floor((Math.log(rightChildPos) / Math.log(2)) + 1);
                que.addLast(head.right);
            }

            if (nextLevelToAdd != -1 && nextLevelToAdd != lastLevel) {
                lastLevel = nextLevelToAdd;
                maxCount += Math.pow(2, lastLevel - 1);
            }

            if (head.val == -1) {   // null
                ret.append(",null");
            } else {
                ret.append(",").append(head.val);
            }

            if (countTillNow == maxCount) {
                break;
            }
        }

        return ret.subSequence(1, ret.length()).toString();
    }*/
}
