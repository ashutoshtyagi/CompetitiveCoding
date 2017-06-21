package com.fancita.leetcode.Tree;

import java.util.ArrayDeque;

/**
 * Created by ashutosh on 7/3/17.
 * http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 */
public class PrintAllNodesAtDistanceKFromGivenNode {

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

        new PrintAllNodesAtDistanceKFromGivenNode().printkdistanceNode(root, root, 2);
    }

    public int printkdistanceNode(TreeNode root, TreeNode target, int k) {
        StringBuilder printString = new StringBuilder();
        boolean present = printAncestorNodesAtDistanceK(root, target, k, printString);
        if (present) {
            printChildrenAtDistanceK(target, k, printString);
            System.out.println(printString.toString());
            return -1;
        }
        return 1;
    }

    private boolean printAncestorNodesAtDistanceK(TreeNode root, TreeNode target, int k, StringBuilder printString) {
        ArrayDeque<TreeNode> stack = getStackContainingAncestorNodes(root, target);
        if (stack.size() == 0) return root == target;

        if (k == 0) return true;

        int stackPoppedCount = 0;
        TreeNode present = null, prev = target;

        while (stackPoppedCount < k && stack.size() > 0) {
            present = stack.removeFirst();
            stackPoppedCount++;

            if (present.left == prev) {
                printChildrenAtDistanceK(present.right, k - stackPoppedCount - 1, printString);
            } else {
                printChildrenAtDistanceK(present.left, k - stackPoppedCount - 1, printString);
            }

            prev = present;
        }

        if (prev != null && stackPoppedCount == k) {
            printString.append(prev.val + " ");
        }

        return true;
    }

    private ArrayDeque<TreeNode> getStackContainingAncestorNodes(TreeNode root, TreeNode target) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        addNodesToStack(root, target, stack);
        return stack;
    }

    private boolean addNodesToStack(TreeNode presentNode, TreeNode target, ArrayDeque<TreeNode> stack) {
        if (presentNode == null) return false;
        if (presentNode == target) return true;

        stack.addFirst(presentNode);
        boolean left = addNodesToStack(presentNode.left, target, stack);
        boolean right = addNodesToStack(presentNode.right, target, stack);

        if (!left && !right) stack.removeFirst();

        return left || right;
    }

    private void printChildrenAtDistanceK(TreeNode node, int k, StringBuilder printString) {
        if (node == null || k < 0) return;
        if (k == 0) {
            printString.append(node.val + " ");
            return;
        }

        printChildrenAtDistanceK(node.left, k - 1, printString);
        printChildrenAtDistanceK(node.right, k - 1, printString);
    }
}
